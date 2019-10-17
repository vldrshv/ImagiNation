package com.example.imagination.les3__image_recycler_extended.presenter

import android.annotation.SuppressLint
import com.example.imagination.R
import com.example.imagination.img_api.ImageProvider
import com.example.imagination.img_api.SearchImageProvider
import com.example.imagination.img_api.model.ImageReqResult
import com.example.imagination.img_api.model.Photo
import com.example.imagination.les3__image_recycler_extended.view.IViewHolder
import com.example.imagination.les3__image_recycler_extended.view.PhotoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class RecyclerViewPresenter : IRecyclerViewPresenter, MvpPresenter<PhotoView>() {

    private val CLASS_TAG = "RecyclerViewPresenter"

    private var photoList: ArrayList<Photo> = arrayListOf()
    private var imageProvider: SearchImageProvider = ImageProvider.createSearchImageProvider()

    init {
        getPhotos()
    }

    @SuppressLint("CheckResult")
    private fun getPhotos() {
        imageProvider.searchImage()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe (
                { result: ImageReqResult -> run {
                    photoList.addAll(result.photos)
                    viewState.notifyDataChanged()
                }},
                { error -> error.printStackTrace() }
            )
    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]

        iViewHolder.setImageOne(photoModel.src.landscape)
        iViewHolder.setBackground(R.color.colorGray)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun clicked(pos: Int) {
        viewState.showToast("$pos")
        val img = photoList[pos]
        viewState.showToast(img.url)
        viewState.openImage(img.id)
    }
}