package com.example.imagination.core.view.recycler

import android.graphics.Point
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;
import com.example.imagination.R
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.imagination.core.presenter.BasePhotoPresenter
import com.example.imagination.core.presenter.RecyclerViewPresenter
import com.squareup.picasso.Picasso
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

class MyAdapter (var presenter: BasePhotoPresenter, var screenSize: Point, var isPortrait: Boolean)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_grid, parent, false)
        return MyViewHolder(view, presenter, screenSize, isPortrait)
    }

    override fun getItemCount(): Int {
        return presenter.getItemCount()
    }

    @StateStrategyType(value = SingleStateStrategy::class)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        presenter.bindView(holder)
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    class MyViewHolder(itemView: View, var presenter: BasePhotoPresenter, screenSize: Point, isPortrait: Boolean)
        : RecyclerView.ViewHolder(itemView), IViewHolder, View.OnClickListener {
        private val CLASS_TAG = "MyViewHolder"

        private var image: ImageView = itemView.findViewById(R.id.image)
        private var width: Int = screenSize.x / if (isPortrait) 2 else 3 //for horizontal
        private var height: Int = screenSize.y / 3

        init {
            itemView.setOnClickListener(this)
        }

        override fun setImageOne(sourceUrl: String) {
            Log.i(CLASS_TAG, sourceUrl)
            Picasso.get().load(sourceUrl)/*.resize(width, height).centerCrop()*/.into(image)
        }

        override fun getPos() = position

        override fun onClick(v: View?) {
            println(getPos())
            presenter.clicked(getPos())
        }
    }
}