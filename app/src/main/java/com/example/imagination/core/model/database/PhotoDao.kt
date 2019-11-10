package com.example.imagination.core.model.database

import androidx.room.*
import com.example.imagination.core.model.entity.Photo
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface PhotoDao {
    @Query("SELECT * FROM Photo")
    fun getAll(): Flowable<List<Photo>>

    @Query("SELECT * FROM Photo WHERE liked = :flag")
    fun getLikedPhotos(flag: Boolean = true): Flowable<List<Photo>>

    @Query("SELECT * FROM Photo WHERE id = :id")
    fun getById (id: Int): Single<Photo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (Photo: Photo)

    @Update
    fun update (Photo: Photo)

    @Delete
    fun deletePhoto (Photo: Photo)

    @Query("DELETE FROM Photo WHERE liked = :isLiked")
    fun deletePhotos(isLiked: Boolean)
}