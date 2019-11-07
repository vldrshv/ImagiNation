package com.example.imagination.core.model.database

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.room.Room

class AppDatabaseConfig : Application() {
    private val CLASS_TAG = "AppDatabaseConfig"
    private var database: PhotoDatabase? = null
    private lateinit var appSettings: SharedPreferences

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, PhotoDatabase::class.java, "database")
            .build()
        appSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        Log.i(CLASS_TAG, "database $CLASS_TAG has ben created")
    }
    fun getDatabase() = database!!
    fun getSettings() = appSettings

    companion object {
        private var instance: AppDatabaseConfig? = null
        fun getInstance() = instance!!
    }
}