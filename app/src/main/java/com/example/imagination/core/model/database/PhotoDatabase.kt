package com.example.imagination.core.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.imagination.core.model.entity.Photo
import com.example.imagination.core.model.entity.PhotoSource

@Database(entities = [Photo::class, PhotoSource::class], version = 2)
abstract class PhotoDatabase : RoomDatabase() {
    private val CLASS_TAG = "LikedPhotoDatabase"
    abstract fun getLikedPhotosDao() : PhotoDao
    abstract fun getPhotoSourceDao() : PhotoSourceDao
}