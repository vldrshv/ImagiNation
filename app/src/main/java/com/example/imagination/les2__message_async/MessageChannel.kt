package com.example.imagination.les2__message_async

import android.util.Log

class MessageChannel : Observable {
    private val CLASS_TAG = "MessageChannel"

    val words: ArrayList<String> = arrayListOf<String>(
        " many", " people", " like", " coding", " but", " not", " all",
        " do", " it", " in", " clean", " way")
    var message = ""

    private var observers: ArrayList<Observer> = arrayListOf()

    // "server" of spam messages
    private var thread: Thread = Thread(Runnable {
        while (true) {
            generateMessage()
            notifyAllObservers()
            Thread.sleep(3000)
        }
    })

    init {
        thread.start()
        Log.i(CLASS_TAG, "generator started")
    }

    private fun generateMessage() {
        var randInd: Int
        message = ""
        for (i in 0..(words.size/2)) {
            randInd = (Math.random() * 100 % words.size).toInt()
            message += words[randInd]
        }
    }

    override fun subscribe(observer: Observer) {
        observers.add(observer)
        Log.i(CLASS_TAG, "registered observer ${observers.size - 1}")
    }

    override fun unsubscribe(observer: Observer) {
        Log.i(CLASS_TAG, "unregistered observer ${observers.indexOf(observer)}")
        observers.remove(observer)
    }

    override fun notifyAllObservers() {
        Log.i(CLASS_TAG, "number to notify: ${observers.size}")
        for (i in 0 until observers.size)
            if (observers[i].spamEnabled)
                observers[i].updateData(message)
    }
}