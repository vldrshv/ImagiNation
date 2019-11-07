package com.example.imagination.core.api

import com.example.imagination.core.model.entity.ImageReqResult
import com.example.imagination.core.model.entity.Photo
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ImageApi {
    @GET("curated")
    fun getImages(@Header("Authorization") authorization: String,
                  @QueryMap options: Map<String, String>): Observable<ImageReqResult>

    @GET("photos/{id}")
    fun getImage(@Header("Authorization") authorization: String,
                  @Path("id") id: Int): Observable<Photo>

    companion object Factory {
        fun create() : ImageApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.pexels.com/v1/")
                .build()
            return retrofit.create(ImageApi::class.java)
        }
    }
}
