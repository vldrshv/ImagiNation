package com.example.imagination.les5__room.view

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IView : MvpView {
    @StateStrategyType(value = SingleStateStrategy::class)
    fun dataChanged()
    @StateStrategyType(value = SkipStrategy::class)
    fun showLoading(flag: Boolean)
    @StateStrategyType(value = SingleStateStrategy::class)
    fun showEditDialog()
}