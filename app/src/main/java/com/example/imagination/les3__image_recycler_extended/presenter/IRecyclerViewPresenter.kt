package com.example.imagination.les3__image_recycler_extended.presenter

import com.example.imagination.les3__image_recycler_extended.view.IViewHolder


interface IRecyclerViewPresenter {
    fun bindView(iViewHolder: IViewHolder)
    fun getItemCount(): Int

//    fun setPosition(pos: Int)
    fun clicked(pos: Int)
}