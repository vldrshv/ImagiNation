package com.example.imagination.core.view.recycler

import com.squareup.picasso.Picasso

interface IViewHolder {
    fun setImageOne(sourceUrl: String)
    fun getPos(): Int
}