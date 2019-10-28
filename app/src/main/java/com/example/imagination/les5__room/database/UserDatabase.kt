package com.example.imagination.les5__room.database

import androidx.room.RoomDatabase
import androidx.room.Database


@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    private val CLASS_TAG = "UserDatabase"
    abstract fun userDao(): UserDao
}