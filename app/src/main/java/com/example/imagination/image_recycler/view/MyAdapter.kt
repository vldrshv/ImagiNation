package com.example.imagination.image_recycler.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;
import com.example.imagination.R
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.imagination.image_recycler.presenter.RecyclerViewPresenter

class MyAdapter(var recyclerViewPresenter: RecyclerViewPresenter)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_grid, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recyclerViewPresenter.getItemCount()
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        recyclerViewPresenter.bindView(holder);
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), IViewHolder {
        private var image: ImageView = itemView.findViewById(R.id.image)

        override fun setImageOne(imageId: Int) = image.setImageResource(imageId)

        override fun setGrayBackground() = image.setBackgroundColor(R.color.colorGray)

        override fun getPos() = position

    }
}