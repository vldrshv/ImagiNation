package com.example.imagination.text_viewer

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IView : MvpView {
//    @StateStrategyType(value = AddToEndStrategy::class)
//    fun getText(): String

    @StateStrategyType(value = AddToEndStrategy::class)
    fun setText(text: String)
}
