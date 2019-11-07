package com.example.imagination.core.presenter

import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.imagination.core.api.ImageProvider
import com.example.imagination.core.api.SearchImageProvider
import com.example.imagination.core.model.entity.ImageReqResult
import com.example.imagination.core.model.entity.Photo
import com.example.imagination.core.view.recycler.IViewHolder
import com.example.imagination.core.view.PhotoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class RecyclerViewPresenter : BasePhotoPresenter, MvpPresenter<PhotoView>() {

    private val CLASS_TAG = "RecyclerViewPresenter"

    private var photoList: ArrayList<Photo> = arrayListOf()
    private var imageProvider: SearchImageProvider = ImageProvider.createSearchImageProvider()

    init {
        getPhotos()
    }

    @SuppressLint("CheckResult")
    private fun getPhotos(page: Int = 0) {
        viewState.showLoading(true)

        if (page == 1)
            imageProvider.resetPage()

        imageProvider.searchImage()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe (
                { result: ImageReqResult -> run {
                    photoList.addAll(result.photos)
                    viewState.notifyDataChanged()
                    viewState.showLoading(false)
                }},
                { error -> error.printStackTrace() }
            )
    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]

        iViewHolder.setImageOne(photoModel.src.landscape)
        Log.i(CLASS_TAG, photoModel.toString())
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun clicked(pos: Int) {
        val img = photoList[pos]
        viewState.showToast(img.url)
        Log.i(CLASS_TAG, img.toString())
        viewState.openImage(img.id)
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
            getPhotos(1)
            viewState.stopRefreshing()
        }
    }
}