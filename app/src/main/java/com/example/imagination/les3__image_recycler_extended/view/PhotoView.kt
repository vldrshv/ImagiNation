package com.example.imagination.les3__image_recycler_extended.view

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PhotoView : MvpView {
    @StateStrategyType(value = SingleStateStrategy::class)
    fun showToast(s: String)
    @StateStrategyType(value = SkipStrategy::class)
    fun openImage(imageId: Int, backgroundColor: Int)
}