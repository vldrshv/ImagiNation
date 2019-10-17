package com.example.imagination.les3__image_recycler_extended.view

import android.graphics.Color
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;
import com.example.imagination.R
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.imagination.img_api.model.Photo
import com.example.imagination.les3__image_recycler_extended.presenter.RecyclerViewPresenter
import com.squareup.picasso.Picasso
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import kotlin.random.Random

class MyAdapter (var recyclerViewPresenter: RecyclerViewPresenter)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var photoList: List<Photo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_grid, parent, false)
        return MyViewHolder(view, recyclerViewPresenter)
    }

    override fun getItemCount(): Int {
        return recyclerViewPresenter.getItemCount()
    }

    @StateStrategyType(value = SingleStateStrategy::class)
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        recyclerViewPresenter.bindView(holder)
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    class MyViewHolder(itemView: View, var presenter: RecyclerViewPresenter)
        : RecyclerView.ViewHolder(itemView), IViewHolder, View.OnClickListener {
        private val CLASS_TAG = "MyViewHolder"

        private var image: ImageView = itemView.findViewById(R.id.image)

        init {
            itemView.setOnClickListener(this)
        }

//        override fun setImageOne(id: Int) {
        override fun setImageOne(sourceUrl: String) {

            Log.i(CLASS_TAG, sourceUrl)
            Picasso.get().load(sourceUrl).into(image)
//            image.setImageResource(imageId)
//            image.setImageResource(id)//R.drawable.ic_launcher_foreground)
        }

        override fun setBackground(color: Int) {
//            image.setBackgroundColor(color)
        }

        override fun getPos() = position

        override fun onClick(v: View?) {
            println(getPos())
            presenter.clicked(getPos())
        }
    }
}