package com.example.imagination.core.model.database

import androidx.room.*
import com.example.imagination.core.model.entity.PhotoSource
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface PhotoSourceDao {
    @Query("SELECT * FROM PhotoSource")
    fun getAll(): Flowable<List<PhotoSource>>

    @Query("SELECT * FROM PhotoSource WHERE source_id = :id")
    fun getById (id: Int): Single<PhotoSource>

    @Insert
    fun insert (photoSource: PhotoSource)

    @Update
    fun update (photoSource: PhotoSource)

    @Delete
    fun delete (photoSource: PhotoSource)
}