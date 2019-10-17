package com.example.imagination.img_api

import android.util.Log
import com.example.imagination.img_api.model.ImageReqResult
import io.reactivex.Observable

object ImageProvider {
    fun createSearchImageProvider(): SearchImageProvider = SearchImageProvider(ImageApi.create())
}

class SearchImageProvider (val imageApi: ImageApi) {
    private val API_KEY = "563492ad6f91700001000001bbe6a4290bbb462bbcba67827d5b7f01"
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