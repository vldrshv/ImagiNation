package com.example.imagination.les3__image_recycler_extended.presenter

import android.annotation.SuppressLint
import com.example.imagination.img_api.ImageProvider
import com.example.imagination.img_api.SearchImageProvider
import com.example.imagination.img_api.SingleImageProvider
import com.example.imagination.img_api.model.Photo
import com.example.imagination.les3__image_recycler_extended.view.SinglePhotoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SinglePhotoPresenter (view: SinglePhotoView) {
    private val CLASS_TAG = "RecyclerViewPresenter"

    private var photo: Photo = Photo()
    private var imageProvider: SingleImageProvider = ImageProvider.createSingleImageProvider()
    private var _view = view


    @SuppressLint("CheckResult")
    fun getPhoto(id: Int) {
        imageProvider.searchImage(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> run {
                         photo = result
                        _view.showImage(photo.src.large2x)
                        _view.showDescription(createDescription())
                    }
                },
                { error -> error.printStackTrace()}
            )
    }

    private fun createDescription(): String {
        return "${photo.photographer} - ${photo.id}"
    }
}