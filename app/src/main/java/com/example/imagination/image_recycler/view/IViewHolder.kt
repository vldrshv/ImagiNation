package com.example.imagination.image_recycler.view

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IViewHolder {
    fun setImageOne(imageId: Int)
    fun setGrayBackground()
    fun getPos(): Int
}