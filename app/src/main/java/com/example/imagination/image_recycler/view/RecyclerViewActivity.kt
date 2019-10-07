package com.example.imagination.image_recycler.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagination.R
import com.example.imagination.image_recycler.presenter.RecyclerViewPresenter
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private var recyclerViewPresenter: RecyclerViewPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        recyclerViewPresenter = RecyclerViewPresenter()
        initRecycleView()
    }

    private fun initRecycleView() {
        val layoutManager = GridLayoutManager(this, 2)
            photo_recycle_view.layoutManager = layoutManager
            val myAdapter = MyAdapter(recyclerViewPresenter!!.getPresenter())
            photo_recycle_view.adapter = myAdapter
    }
}