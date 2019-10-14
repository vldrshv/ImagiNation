package com.example.imagination.les2__message_async

interface Observer {
    var spamEnabled: Boolean
    fun updateData(s: String)
}