package com.example.imagination.text_viewer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.imagination.R
import com.example.imagination.text_viewer.Interface
import com.example.imagination.text_viewer.presenter.TextViewPresenter
import kotlinx.android.synthetic.main.activity_text_view.*

class TextViewActivity : AppCompatActivity(), View.OnClickListener, Interface.View {
    private val CLASS_TAG = "TextViewActivity"
    private var textViewPresenter: Interface.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        textViewPresenter = TextViewPresenter(this)
        buttonConcat.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.i(CLASS_TAG, "initiateConcat()")
        textViewPresenter?.initiateConcat()
    }

    override fun getText(): String {
        Log.i(CLASS_TAG, "view.getText()")
        return inputText.text.toString()
    }

    override fun setText(text: String) {
        Log.i(CLASS_TAG, "view.setText()")
        multilineText.setText(text)
    }
}
