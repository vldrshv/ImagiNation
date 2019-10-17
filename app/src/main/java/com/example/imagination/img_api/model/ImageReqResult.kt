package com.example.imagination.img_api.model

class ImageReqResult {
    var page: Int = 0
    var per_page: Int = 0

    var url: String = ""
    var next_page: String = ""
    var photos = arrayListOf<Photo>()
}