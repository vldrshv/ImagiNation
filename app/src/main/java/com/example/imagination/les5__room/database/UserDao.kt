package com.example.imagination.les5__room.database

import androidx.room.*
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll(): Flowable<List<User>>

    @Query("SELECT * FROM User WHERE id = :id")
    fun getById (id: Long): Single<User>

    @Insert
    fun insert (user: User)

    @Update
    fun update (user: User)

    @Delete
    fun delete (user: User)

}