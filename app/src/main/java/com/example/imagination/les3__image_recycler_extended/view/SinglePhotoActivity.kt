package com.example.imagination.les3__image_recycler_extended.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.imagination.R
import com.example.imagination.les3__image_recycler_extended.presenter.SinglePhotoPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_single_photo.*

class SinglePhotoActivity : AppCompatActivity(), SinglePhotoView {

    private val CLASS_TAG = "SinglePhotoActivity"
    private var presenter: SinglePhotoPresenter = SinglePhotoPresenter(this)

    // todo add presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_photo)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        expandBtn.setOnClickListener { externalInfoLayout.visibility = if (externalInfoLayout.visibility == View.VISIBLE) View.GONE else View.VISIBLE }
        restoreView()
    }

    override fun showImage(url: String) {
        Log.i(CLASS_TAG, url)
        Picasso.get().load(url).into(imageView)
    }

    override fun showDescription(description: String) {
        descriptionTv.text = description
    }

    private fun restoreView() {
        val imageId = intent.getIntExtra("imageId", 0)
        presenter.getPhoto(imageId)
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
