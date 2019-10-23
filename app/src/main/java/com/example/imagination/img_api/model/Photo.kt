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
        override fun toString(): String {
            return "Source(original='$original', large='$large', large2x='$large2x', medium='$medium', small='$small', portrait='$portrait', landscape='$landscape', tiny='$tiny')"
        }

    }

    override fun toString(): String {
        return "Photo(id=$id, width=$width, height=$height, url='$url', photographer='$photographer', src=$src)"
    }


}