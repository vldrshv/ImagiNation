package com.example.imagination.les2__message_async.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.imagination.R
import com.example.imagination.les2__message_async.MessageChannel
import com.example.imagination.les2__message_async.SomeObserver
import kotlinx.android.synthetic.main.activity_observer.*

class ObserverActivity : AppCompatActivity(), View.OnClickListener {

    var someObserver: SomeObserver = SomeObserver()
    var messageChannel: MessageChannel = MessageChannel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observer)

        subscribeBtn.setOnClickListener(this)
        unsubscribeBtn.setOnClickListener(this)
        spamBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.subscribeBtn -> messageChannel.subscribe(someObserver)
            R.id.unsubscribeBtn -> messageChannel.unsubscribe(someObserver)
            R.id.spamBtn -> someObserver.changeSpamStatus()//someObserver.spamEnabled = !someObserver.spamEnabled
        }
    }
}

