package com.example.imagination.core.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.example.imagination.core.api.ImageProvider
import com.example.imagination.core.api.SingleImageProvider
import com.example.imagination.core.model.entity.Photo
import com.example.imagination.core.view.SinglePhotoView
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
                        _view.showPhotographer(createPhotographerDescription())
                    }
                },
                { error -> error.printStackTrace()}
            )
    }

    private fun createDescription(): String {
        // url='https://www.pexels.com/photo/man-wears-orange-knit-cap-and-shirt-2802601/'
        Log.i(CLASS_TAG, photo.url)
        return photo.createDescription()
    }

    private fun createPhotographerDescription(): String {
        return "${photo.photographer} - ${photo.id}"
    }

    fun getLoadedPhoto() = photo
}