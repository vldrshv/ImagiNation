package com.example.imagination.les3__image_recycler_extended.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.example.imagination.R
import com.example.imagination.img_api.ImageApi
import com.example.imagination.img_api.ImageProvider
import com.example.imagination.img_api.SearchImageProvider
import com.example.imagination.img_api.model.ImageReqResult
import com.example.imagination.img_api.model.Photo
import com.example.imagination.les3__image_recycler_extended.model.ClickedPhoto
import com.example.imagination.les3__image_recycler_extended.model.PhotoModel
import com.example.imagination.les3__image_recycler_extended.view.IViewHolder
import com.example.imagination.les3__image_recycler_extended.view.MyAdapter
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
//        var photo: Photo = Photo()
//        for (i in 0..30) {
//            photo = Photo()
//            photo.id = R.drawable.ic_launcher_foreground
//            photoList.add(photo)
//        }

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
//                    Log.i(CLASS_TAG, photoList.size.toString())
                    viewState.notifyDataChanged()
                }},
                { error -> error.printStackTrace() }
            )
    }

    override fun bindView(iViewHolder: IViewHolder) {
        Log.i(CLASS_TAG, "bindView")
        Log.i(CLASS_TAG, photoList.size.toString())
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]
//        iViewHolder.setImageOne(photoModel.id)
        iViewHolder.setImageOne(photoModel.src.medium)

    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun clicked(pos: Int) {
        viewState.showToast("$pos")
        val img = photoList[pos]
        viewState.showToast(img.url)
//        viewState.openImage(img.imageId, img.backgroundColor)
    }
}