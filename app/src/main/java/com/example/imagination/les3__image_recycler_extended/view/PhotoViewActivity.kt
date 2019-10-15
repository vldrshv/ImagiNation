package com.example.imagination.les3__image_recycler_extended.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagination.R
import com.example.imagination.les3__image_recycler_extended.presenter.RecyclerViewPresenter
import kotlinx.android.synthetic.main.activity_recycle_view.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class PhotoViewActivity : MvpAppCompatActivity(), PhotoView {
    //: AppCompatActivity() {

    private val CLASS_TAG = "PhotoViewActivity"

    @InjectPresenter
    lateinit var recyclerViewPresenter: RecyclerViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

//        recyclerViewPresenter = RecyclerViewPresenter()
        initRecycleView()
    }

    private fun initRecycleView() {
        val layoutManager = GridLayoutManager(this, 2)
        photo_recycle_view.layoutManager = layoutManager
        val myAdapter = MyAdapter(recyclerViewPresenter)
        photo_recycle_view.adapter = myAdapter
    }

    override fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

//    override fun openImage(: Int) {
//        var intent: Intent = Intent(this, SinglePhotoActivity::class.java)
//        intent.putExtra("image", id)
//        startActivity(intent)
//    }
}