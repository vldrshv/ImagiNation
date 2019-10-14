package com.example.imagination.les2__message_async

import android.util.Log

class SomeObserver : Observer {
    private val CLASS_TAG = "SomeObserver"

    private var message = ""
    override var spamEnabled: Boolean = false

    override fun updateData(s: String) {
        message = s
        Log.i(CLASS_TAG, "observer got message: $message")
    }

    fun changeSpamStatus() { spamEnabled = !spamEnabled }
}