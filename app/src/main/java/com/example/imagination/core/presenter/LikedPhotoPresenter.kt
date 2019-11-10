package com.example.imagination.core.presenter

import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.imagination.AppConfig
import com.example.imagination.core.model.SharedPreferencesManager
import com.example.imagination.core.model.database.PhotoDatabase
import com.example.imagination.core.model.entity.Photo
import com.example.imagination.core.model.entity.PhotoSource
import com.example.imagination.core.view.PhotoView
import com.example.imagination.core.view.recycler.IViewHolder
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class LikedPhotoPresenter : BasePhotoPresenter, MvpPresenter<PhotoView>() {
    private val CLASS_TAG = "LikedPhotoPresenter"
    private var db: PhotoDatabase = AppConfig.getInstance().getDatabase()
    private var likedPhotoDao = db.getPhotosDao()
    private var photoSourceDao = db.getPhotoSourceDao()

    private var photoList: ArrayList<Photo> = arrayListOf()

    init {
        getPhotos()
    }

    fun likePhoto(photo: Photo) {
        Log.i(CLASS_TAG, "LIKED - $photo")
        photo.liked = true
        photo.disliked = false
        photo.src.sourceId = photo.id
        saveOrUpdatePhoto(photo)
    }

    fun dislikePhoto(photo: Photo) {
        deleteFromLikedPhotoDB(photo)
    }

    @SuppressLint("CheckResult")
    private fun deleteFromLikedPhotoDB(photo: Photo) {
        Completable.fromAction {
            photoSourceDao.delete(photo.src)
            likedPhotoDao.deletePhoto(photo)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.notifyDataChanged()
                },
                { e: Throwable -> e.printStackTrace() }
            )
    }

    @SuppressLint("CheckResult")
    private fun saveOrUpdatePhoto(photo: Photo) {
        likedPhotoDao.getById(photo.id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe (
                {
                    likedPhotoDao.update(photo)
                    photoSourceDao.update(photo.src)
                },
                {
                    likedPhotoDao.insert(photo)
                    photoSourceDao.insert(photo.src)
                }
            )
    }

    @SuppressLint("CheckResult")
    private fun getPhotos() {
        likedPhotoDao.getLikedPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    photoList.clear()
                    Log.i(CLASS_TAG, "size = ${list.size}")
                    photoList.addAll(list)
                    getPhotoSources()
                    viewState.notifyDataChanged()
                },
                { e: Throwable -> e.printStackTrace() }
            )
    }
    @SuppressLint("CheckResult")
    private fun getPhotoSources() {
        photoList.forEach {
            photoSourceDao.getById(it.id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(
                    { source: PhotoSource? ->
                        println(it)
                        it.src = source!! },
                    { e: Throwable -> e.printStackTrace() }
                )
        }
    }

    override fun recyclerViewEndPageListener() : RecyclerView.OnScrollListener {
        return object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val pos = (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                if (!recyclerView.canScrollVertically(1) && photoList.isNotEmpty()) {
                    getPhotos()
                }
            }
        }
    }

    override fun recyclerViewRefreshListener () : SwipeRefreshLayout.OnRefreshListener {
        return SwipeRefreshLayout.OnRefreshListener {
            viewState.stopRefreshing()
        }
    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]

        if(photoModel.src.landscape != "")
            iViewHolder.setImageOne(photoModel.src.large)
        Log.i(CLASS_TAG, photoModel.toString())
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun clicked(pos: Int) = viewState.openImage(photoList[pos].id)
}