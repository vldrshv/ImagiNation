package com.example.imagination.les3__image_recycler_extended.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imagination.R
import com.example.imagination.les3__image_recycler_extended.presenter.RecyclerViewPresenter
import kotlinx.android.synthetic.main.activity_recycle_view.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class PhotoViewActivity : MvpAppCompatActivity(), PhotoView {

    private val CLASS_TAG = "PhotoViewActivity"

    @InjectPresenter
    lateinit var recyclerViewPresenter: RecyclerViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        initRecycleView()
        initRefreshing()
    }

    private fun initRecycleView() {
        val layoutManager = GridLayoutManager(this, 2)
        photo_recycle_view.layoutManager = layoutManager
        photo_recycle_view.addOnScrollListener(recyclerViewPresenter.recyclerViewEndPageListener())
        val myAdapter = MyAdapter(recyclerViewPresenter)
        photo_recycle_view.adapter = myAdapter
    }

    private fun initRefreshing() {
        refreshLayout.setOnRefreshListener(recyclerViewPresenter.recyclerViewRefreshListener())
    }
    override fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

    override fun openImage(imageId: Int) {
        val intent: Intent = Intent(this, SinglePhotoActivity::class.java)
        intent.putExtra("imageId", imageId)
        startActivity(intent)
    }

    override fun notifyDataChanged() {
        val myAdapter = photo_recycle_view.adapter
        myAdapter!!.notifyDataSetChanged()
    }

    override fun stopRefreshing() {
        refreshLayout.isRefreshing = false
    }

    override fun showLoading(isShown: Boolean) {
        progressBar.visibility = if (isShown) View.VISIBLE else View.GONE
    }


}