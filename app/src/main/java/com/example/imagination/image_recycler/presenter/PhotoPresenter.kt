package com.example.imagination.image_recycler.presenter

import com.example.imagination.R
import com.example.imagination.image_recycler.model.PhotoModel

class PhotoPresenter : IPhotoPresenter {
    private var photoList: ArrayList<PhotoModel>? = null

    init {
        photoList = arrayListOf()
        photoList!!.add(PhotoModel(R.drawable.ic_launcher_foreground))
        photoList!!.add(PhotoModel(R.drawable.ic_launcher_foreground))
        photoList!!.add(PhotoModel(R.drawable.ic_launcher_foreground))
        photoList!!.add(PhotoModel(R.drawable.ic_launcher_foreground))
        photoList!!.add(PhotoModel(R.drawable.ic_launcher_foreground))
        photoList!!.add(PhotoModel(R.drawable.ic_launcher_foreground))
        photoList!!.add(PhotoModel(R.drawable.ic_launcher_foreground))

    }

    override fun getPhotoList(): List<PhotoModel> = photoList!!
}