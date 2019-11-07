package com.example.imagination.core.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PhotoSource {
    @ColumnInfo(name = "source_id") @PrimaryKey(autoGenerate = false)
    var sourceId: Int = 0
    var original: String =  ""
    var large: String =  ""
    var large2x: String =  ""
    var medium: String =  ""
    var small: String =  ""
    var portrait: String =  ""
    var landscape: String =  ""
    var tiny: String =  ""
    override fun toString(): String {
        return "Source(sourceId = $sourceId, original='$original', large='$large', large2x='$large2x', medium='$medium', small='$small', portrait='$portrait', landscape='$landscape', tiny='$tiny')"
    }

}