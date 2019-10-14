package com.example.imagination.les3__rxkotlin_lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.imagination.R
import com.example.imagination.les2__rxkotlin.ActivityView
import kotlinx.android.synthetic.main.activity_lambda.*

class LambdaActivity : AppCompatActivity(), ActivityView {

    private var presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambda)

        subscribeBtn.setOnClickListener {
            presenter.subscribe()
            setText("+\tsubscribe\n")
        }
        unsubscribeBtn.setOnClickListener {
            presenter.unsubscribe()
            setText("-\tunsubscribe\n") }
    }

    override fun setText(s: String) {
        logTv.append(s + "\n")
    }
}
