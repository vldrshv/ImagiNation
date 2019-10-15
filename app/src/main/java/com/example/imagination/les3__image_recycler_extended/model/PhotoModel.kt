package com.example.imagination.les3__image_recycler_extended.model

import android.graphics.Color
import kotlin.random.Random

class PhotoModel (
    var imageId: Int
) {
    var backgroundColor = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
}