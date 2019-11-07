package com.example.imagination.core.presenter

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.imagination.core.view.recycler.IViewHolder


interface BasePhotoPresenter {
    fun bindView(iViewHolder: IViewHolder)
    fun getItemCount(): Int

    fun clicked(pos: Int)
    fun recyclerViewEndPageListener() : RecyclerView.OnScrollListener
    fun recyclerViewRefreshListener () : SwipeRefreshLayout.OnRefreshListener
}