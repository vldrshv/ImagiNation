package com.example.imagination.les3__single_rx_lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagination.R
import com.example.imagination.les2__rxkotlin.ActivityView
import kotlinx.android.synthetic.main.activity_single_rx.*

class SingleRxActivity : AppCompatActivity(), ActivityView {

    private var presenter = SingleRxPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_rx)

        getMessageBtn.setOnClickListener { presenter.getMessage() }
    }

    override fun setText(s: String) {
        logTv.append(s)
    }
}
