package com.example.imagination.core.model.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class Photo {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
    var width: Int = 0
    var height: Int = 0
    var url: String = ""
    var photographer: String = "Name"

    @Ignore
    var src: PhotoSource = PhotoSource()
    var liked: Boolean = false
    var disliked: Boolean = false



    // url='https://www.pexels.com/photo/man-wears-orange-knit-cap-and-shirt-2802601/'
    fun createDescription() : String {
        val stringUrl = "https://www.pexels.com/photo/"
        var description = url
        description = description.replace(stringUrl, "")
            .replace("/", "")
            .replace("$id", "")
            .replace('-', ' ')

        return description
    }

    override fun toString(): String {
        return "Photo(id=$id, width=$width, height=$height, url='$url', photographer='$photographer', src=$src, liked=$liked, disliked=$disliked)"
    }


}