package com.example.imagination.image_recycler.presenter

import com.example.imagination.image_recycler.view.IViewHolder

interface IRecyclerViewPresenter {
    fun bindView(iViewHolder: IViewHolder)
    fun getItemCount(): Int
}