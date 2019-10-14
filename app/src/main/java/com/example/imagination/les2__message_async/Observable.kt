package com.example.imagination.les2__message_async

interface Observable {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
    fun notifyAllObservers()
}