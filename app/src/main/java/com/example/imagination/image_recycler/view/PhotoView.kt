package com.example.imagination.image_recycler.view

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PhotoView : MvpView {
    @StateStrategyType(value = SingleStateStrategy::class)
    fun showToast(s: String)
}