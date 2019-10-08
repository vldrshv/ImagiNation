package com.example.imagination.image_recycler.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;
import com.example.imagination.R
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import com.example.imagination.image_recycler.presenter.RecyclerViewPresenter
import moxy.InjectViewState
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType


class MyAdapter (var recyclerViewPresenter: RecyclerViewPresenter)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

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


    class MyViewHolder(itemView: View, var presenter: RecyclerViewPresenter)
        : RecyclerView.ViewHolder(itemView), IViewHolder, View.OnClickListener {

        private var image: ImageView = itemView.findViewById(R.id.image)

        init {
            itemView.setOnClickListener(this)
        }

        override fun setImageOne(imageId: Int) = image.setImageResource(imageId)

        override fun setGrayBackground() = image.setBackgroundColor(R.color.colorGray)

        override fun getPos() = position

        override fun onClick(v: View?) {
            println(getPos())
//            presenter.setPosition(getPos())
            presenter.clicked(getPos())
        }
    }
}