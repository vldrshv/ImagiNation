package com.example.imagination.async_task

import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import com.example.imagination.R
import kotlinx.android.synthetic.main.activity_async_task.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter


class AsyncTaskActivity : MvpAppCompatActivity(), IAsyncView, View.OnClickListener {
    private val CLASS_TAG = "AsyncTaskActivity"

    @InjectPresenter
    lateinit var presenter: AsyncPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        buttonAsyncTask.setOnClickListener(this)
        tvLog.movementMethod = ScrollingMovementMethod()
    }

    override fun onClick(v: View?) {
        Log.i(CLASS_TAG, "clicked()")
        presenter.execute()
    }

    override fun setText(s: String) {
        tvLog.text = Html.fromHtml(s)
        Log.i(CLASS_TAG, "setText()")
    }

}
