package com.example.imagination.text_viewer.presenter

import com.example.imagination.text_viewer.Interface
import com.example.imagination.text_viewer.model.TextModel

class TextViewPresenter(view: Interface.View) : Interface.Presenter {
    private val CLASS_TAG = "TextViewPresenter"
    private var textModel: TextModel? = TextModel()
    private var textViewActivity: Interface.View? = view

    override fun initiateConcat() {
        val newText = getTextFromView()
        concatText(newText)
        setTextToView()
    }

    override fun getTextFromView(): String {
        return textViewActivity!!.getText()
    }

    override fun setTextToView() {
        textViewActivity!!.setText(textModel!!.text)
    }

    override fun concatText(s: String) {
        textModel!!.text = textModel!!.text + s
    }

}