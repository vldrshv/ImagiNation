package com.example.imagination.core.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.imagination.core.api.ImageProvider
import com.example.imagination.core.api.SearchImageProvider
import com.example.imagination.core.model.SharedPreferencesManager
import com.example.imagination.AppConfig
import com.example.imagination.core.model.database.PhotoDatabase
import com.example.imagination.core.model.entity.ImageReqResult
import com.example.imagination.core.model.entity.Photo
import com.example.imagination.core.model.entity.PhotoSource
import com.example.imagination.core.view.recycler.IViewHolder
import com.example.imagination.core.view.PhotoView
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class GalleryPresenter(context: Context) : BasePhotoPresenter, MvpPresenter<PhotoView>() {

    private val CLASS_TAG = "RecyclerViewPresenter"
    // providers
    private var imageProvider: SearchImageProvider = ImageProvider.createSearchImageProvider()
    private var appSettings: SharedPreferencesManager = SharedPreferencesManager(context)
    // db
    private var db: PhotoDatabase = AppConfig.getInstance().getDatabase()
    private var likedPhotoDao = db.getPhotosDao()
    private var photoSourceDao = db.getPhotoSourceDao()
    private lateinit var disposable: Disposable
    // class vars
    private var photoList: ArrayList<Photo> = arrayListOf()
    private lateinit var observablePhotoList: Flowable<Photo>


    init {
        getPhotos()
    }

    private fun getPhotos(page: Int = 0) {
        viewState.showLoading(true)
        Log.d(CLASS_TAG, "getPhotos")
        if (appSettings.isGalleryAutoLoading()) {
            Log.d(CLASS_TAG, "getPhotosFromServer()")
            getPhotosFromServer(page)
        } else {
            if (photoList.size == 0) {
                Log.d(CLASS_TAG, "getPhotosFromDB()")
                getPhotosFromDB()
            }
            viewState.showLoading(false)
        }
    }

    @SuppressLint("CheckResult")
    private fun getPhotosFromDB() {
        photoList.clear()
        disposable = likedPhotoDao.getAll().observeOn(Schedulers.io())
            .subscribe ({ list ->
                Log.i(CLASS_TAG, "size = ${list.size}")
                photoList.addAll(list)
                getPhotoSources()
            }, { e: Throwable -> e.printStackTrace()} )
    }

    @SuppressLint("CheckResult")
    private fun getPhotosFromServer(page: Int = 0) {
        if (page == 1)
            imageProvider.resetPage()

        imageProvider.searchImage()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result: ImageReqResult ->
                    run {
                        photoList.addAll(result.photos)
                        viewState.notifyDataChanged()
                        viewState.showLoading(false)
                    }
                },
                { error -> error.printStackTrace() }
            )
    }

    @SuppressLint("CheckResult")
    private fun getPhotoSources() {
        observablePhotoList = Flowable.create(FlowableOnSubscribe<Photo> { emitter ->
            photoList.forEach {
                try {
                    emitter.onNext(it)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                    return@FlowableOnSubscribe
                }

            }
            emitter.onComplete()
        }, BackpressureStrategy.BUFFER)
        observablePhotoList.subscribeOn(Schedulers.io())
            .subscribe {
                photoSourceDao.getById(it.id).subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe(
                        { src: PhotoSource ->
                            it.src = src
                        },
                        { e: Throwable ->
                            e.printStackTrace()
                            Log.i(CLASS_TAG, "${it.id} :: NOT FOUND")
                        }
                    )
            }
    }

    private fun insertNewPhotos() = Thread(Runnable { savePhoto() }).start()

    private fun savePhoto() {
        photoList.forEach { photo ->
            likedPhotoDao.insert(photo)
            photo.src.sourceId = photo.id
            photoSourceDao.insert(photo.src)
//            Log.d(CLASS_TAG, "photo ${photo.id} ${photo.src.sourceId} ::INSERT")
        }
    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]

        if (photoModel.src.landscape != "")
            iViewHolder.setImageOne(photoModel.src.landscape)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun clicked(pos: Int) = viewState.openImage(photoList[pos].id)

    override fun recyclerViewEndPageListener(): RecyclerView.OnScrollListener {
        return object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && photoList.isNotEmpty()) {
                    getPhotos()
                }
            }
        }
    }

    override fun recyclerViewRefreshListener() =
        SwipeRefreshLayout.OnRefreshListener {
            getPhotos(1)
            viewState.stopRefreshing()
        }

    @SuppressLint("CheckResult")
    fun saveCache() {
        if (::disposable.isInitialized) disposable.dispose()
        appSettings.setGalleryCacheSize(photoList.size)
        likedPhotoDao.getLikedPhotos().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { appSettings.setLikedPhotosCacheSize(it.size) },
                { e: Throwable -> e.printStackTrace() }
            )
        insertNewPhotos()
        appSettings.setLastGalleryUpdateDate()
    }

    fun isAutoSyncEnabled() = appSettings.isGalleryAutoLoading()
}