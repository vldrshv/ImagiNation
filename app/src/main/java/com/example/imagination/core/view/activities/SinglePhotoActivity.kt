package com.example.imagination.core.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.imagination.R
import com.example.imagination.AppConfig
import com.example.imagination.core.presenter.LikedPhotoPresenter
import com.example.imagination.core.presenter.SinglePhotoPresenter
import com.example.imagination.core.view.SinglePhotoView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_single_photo.*
import java.lang.Exception

class SinglePhotoActivity : AppCompatActivity(), SinglePhotoView {

    private val CLASS_TAG = "SinglePhotoActivity"
    private var presenter: SinglePhotoPresenter = SinglePhotoPresenter(this)
    private var daoPresenter: LikedPhotoPresenter = LikedPhotoPresenter()
    private val appSettings = AppConfig.getInstance().getSettings()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(appSettings.getThemeId())
        setContentView(R.layout.activity_single_photo)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setButtonListeners()
        restoreView()

        showLoading(true)
    }

    private fun setButtonListeners() {
        expandBtn.setOnClickListener { showDescription() }
        dislikeBtn.setOnClickListener { daoPresenter.dislikePhoto(presenter.getLoadedPhoto()) }
        likeBtn.setOnClickListener { daoPresenter.likePhoto(presenter.getLoadedPhoto()) }
    }
    private fun showDescription() {
        externalInfoLayout.visibility = if (externalInfoLayout.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        expandBtn.text = if (externalInfoLayout.visibility == View.VISIBLE) "Hide description" else "Show description"
    }
    private fun restoreView() {
        val imageId = intent.getIntExtra("imageId", 0)
        presenter.getPhoto(imageId)
    }

    fun showLoading(isVisible: Boolean) {
        progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }


    override fun showImage(url: String) {
        Log.i(CLASS_TAG, url)
        Picasso.get().load(url).into(imageView, object : Callback{
            override fun onSuccess() {
                showLoading(false)
            }
            override fun onError(e: Exception?) {
                e!!.printStackTrace()
            }
        })
    }
    override fun showPhotographer(photographer: String) {
        photographerTv.text = photographer
    }
    override fun showDescription(description: String) {
        descriptionTv.text = description
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
