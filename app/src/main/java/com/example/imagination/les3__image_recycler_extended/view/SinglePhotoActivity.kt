package com.example.imagination.les3__image_recycler_extended.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.imagination.R
import kotlinx.android.synthetic.main.activity_single_photo.*

class SinglePhotoActivity : AppCompatActivity() {

    private val CLASS_TAG = "SinglePhotoActivity"

    // todo add presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_photo)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        restoreView()
    }

    private fun restoreView() {
        val imageId = intent.getIntExtra("imageId", 0)
        val backgroundColor = intent.getIntExtra("backgroundColor", 0)

        imageView.setImageResource(imageId)
        imageView.setBackgroundColor(backgroundColor)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.i(CLASS_TAG, "onBackPressed")
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
