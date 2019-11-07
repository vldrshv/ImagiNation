package com.example.imagination.core.model.database

import androidx.room.*
import com.example.imagination.core.model.entity.Photo
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface PhotoDao {
    @Query("SELECT * FROM Photo")
    fun getAll(): Flowable<List<Photo>>

    @Query("SELECT * FROM Photo WHERE id = :id")
    fun getById (id: Int): Single<Photo>

    @Insert
    fun insert (Photo: Photo)

    @Update
    fun update (Photo: Photo)

    @Delete
    fun delete (Photo: Photo)
}