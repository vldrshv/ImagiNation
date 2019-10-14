package com.example.imagination.les1__text_viewer.view

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.imagination.R
import com.example.imagination.les1__text_viewer.IView
import com.example.imagination.les1__text_viewer.presenter.TextViewPresenter
import kotlinx.android.synthetic.main.activity_text_view.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class TextViewActivity : MvpAppCompatActivity(), View.OnClickListener, IView {
    private val CLASS_TAG = "TextViewActivity"

    @InjectPresenter
    lateinit var textViewPresenter: TextViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

//        textViewPresenter = TextViewPresenter(this)
        buttonConcat.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.i(CLASS_TAG, "initiateConcat()")
        val newText = inputText.text.toString()
        textViewPresenter.initiateConcat(newText)
    }

//    fun getText(): String {
//        Log.i(CLASS_TAG, "view.getText()")
//        return inputText.text.toString()
//    }

    override fun setText(text: String) {
        Log.i(CLASS_TAG, "view.setText()")
        multilineText.text = text
    }
}
