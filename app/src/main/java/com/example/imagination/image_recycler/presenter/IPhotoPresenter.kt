package com.example.imagination.image_recycler.presenter

import com.example.imagination.image_recycler.model.PhotoModel

interface IPhotoPresenter {
    fun getPhotoList(): List<PhotoModel>
}