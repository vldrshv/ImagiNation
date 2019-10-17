package com.example.imagination.img_api

import com.example.imagination.img_api.model.ImageReqResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface ImageApi {
    @GET("curated")
    fun getImages(@Header("Authorization") authorization: String,
                  @QueryMap options: Map<String, String>): Observable<ImageReqResult>

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
