package com.example.imagination.les5__room.database

import androidx.room.Room
import android.app.Application
import android.util.Log


class AppDatabase : Application() {
    private val CLASS_TAG = "AppDatabase"
    private var database: UserDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, UserDatabase::class.java, "database")
            .build()
        Log.i(CLASS_TAG, "${instance == null}")
    }
    fun getDatabase(): UserDatabase = database!!

    companion object {

        private var instance: AppDatabase? = null
        fun getInstance(): AppDatabase = instance!!
    }
}