package com.example.imagination.les1__image_recycler.presenter

import com.example.imagination.les1__image_recycler.view.IViewHolder

interface IRecyclerViewPresenter {
    fun bindView(iViewHolder: IViewHolder)
    fun getItemCount(): Int

//    fun setPosition(pos: Int)
    fun clicked(pos: Int)
}