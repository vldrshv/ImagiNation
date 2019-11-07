package com.example.imagination.core.view

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PhotoView : MvpView {
    @StateStrategyType(value = SingleStateStrategy::class)
    fun showToast(s: String)
    @StateStrategyType(value = SkipStrategy::class)
    fun openImage(imageId: Int)
    @StateStrategyType(value = SkipStrategy::class)
    fun notifyDataChanged()
    @StateStrategyType(value = SkipStrategy::class)
    fun stopRefreshing()
    @StateStrategyType(value = SkipStrategy::class)
    fun showLoading(isShown: Boolean)
}