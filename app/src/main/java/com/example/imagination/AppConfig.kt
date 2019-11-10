package com.example.imagination

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.imagination.core.model.SharedPreferencesManager
import com.example.imagination.core.model.database.PhotoDatabase

class AppConfig : Application() {
    private val CLASS_TAG = "AppDatabaseConfig"
    private var database: PhotoDatabase? = null
    private lateinit var appSettings: SharedPreferencesManager

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, PhotoDatabase::class.java, "database")
            .build()
        appSettings = SharedPreferencesManager(this)
        Log.i(CLASS_TAG, "database $CLASS_TAG has ben created")
    }
    fun getDatabase() = database!!
    fun getSettings() = appSettings

    companion object {
        private var instance: AppConfig? = null
        fun getInstance() = instance!!
    }
}