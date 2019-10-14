package com.example.imagination.les2__async_task

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IAsyncView : MvpView{
    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun setText(s: String)
}