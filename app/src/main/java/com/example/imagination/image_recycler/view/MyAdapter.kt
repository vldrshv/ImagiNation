package com.example.imagination.image_recycler.view

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;
import com.example.imagination.R
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.imagination.image_recycler.presenter.IRecyclerViewPresenter

class MyAdapter(private var iRecyclerMainPresenter: IRecyclerViewPresenter)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_grid, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return iRecyclerMainPresenter.getItemCount()
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        iRecyclerMainPresenter.bindView(holder);
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), IViewHolder {
        private var image: ImageView = itemView.findViewById(R.id.image)

        override fun setImageOne(imageId: Int) {
            image.setImageResource(imageId)
        }

        override fun getPos() = position

    }
}