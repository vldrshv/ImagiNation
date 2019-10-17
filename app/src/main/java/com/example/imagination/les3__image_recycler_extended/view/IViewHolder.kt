package com.example.imagination.les3__image_recycler_extended.view

interface IViewHolder {
//    fun setImageOne(id: Int)
    fun setImageOne(sourceUrl: String)
    fun setBackground(color: Int)
    fun getPos(): Int
}