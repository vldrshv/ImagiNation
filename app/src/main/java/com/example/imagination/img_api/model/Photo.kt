package com.example.imagination.img_api.model

class Photo {
    var id: Int = 0
    var width: Int = 0
    var height: Int = 0
    var url: String = ""
    var photographer: String = "Name"
    var src: Source =
        Source()

    class Source {
        var original: String =  ""
        var large: String =  ""
        var large2x: String =  ""
        var medium: String =  ""
        var small: String =  ""
        var portrait: String =  ""
        var landscape: String =  ""
        var tiny: String =  ""
    }
}