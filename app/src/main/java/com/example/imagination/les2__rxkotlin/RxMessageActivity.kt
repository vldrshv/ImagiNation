package com.example.imagination.les2__rxkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.imagination.R
import kotlinx.android.synthetic.main.activity_rx_message.*

class RxMessageActivity : AppCompatActivity(), View.OnClickListener, ActivityView {

    val presenter: RxPresenter = RxPresenter(this)
    private val CLASS_TAG = "RxMessageActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_message)

        subscribeRxBtn.setOnClickListener(this)
        unsubscribeRxBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.subscribeRxBtn -> presenter.subscribe()
            R.id.unsubscribeRxBtn -> presenter.unsubscribe()
        }
    }

    override fun setText(s: String) {
        rxTv.text = s
        Log.i(CLASS_TAG, "main activity set text \"$s\", thread name: ${Thread.currentThread().name}")
    }
}
