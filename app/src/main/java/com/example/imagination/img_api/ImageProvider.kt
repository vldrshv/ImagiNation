package com.example.imagination.img_api

import android.util.Log
import com.example.imagination.img_api.model.ImageReqResult
import com.example.imagination.img_api.model.Photo
import io.reactivex.Observable

private val API_KEY = "563492ad6f91700001000001bbe6a4290bbb462bbcba67827d5b7f01"

object ImageProvider {
    fun createSearchImageProvider(): SearchImageProvider = SearchImageProvider(ImageApi.create())
    fun createSingleImageProvider(): SingleImageProvider = SingleImageProvider(ImageApi.create())
}

class SearchImageProvider (private val imageApi: ImageApi) {

    private var _page = 1
    private var CLASS_TAG = "SearchImageProvider"

    fun searchImage(): Observable<ImageReqResult> {
        var options: HashMap<String, String> = hashMapOf()
        options["per_page"] = 20.toString()
        options["page"] = _page.toString()
        increasePage()
        return imageApi.getImages(API_KEY, options)
    }

    private fun increasePage() = _page++
}

class SingleImageProvider(private val imageApi: ImageApi) {
    private var CLASS_TAG = "ImageProvider"

    fun searchImage(id: Int): Observable<Photo> {
        return imageApi.getImage(API_KEY, id)
    }

}