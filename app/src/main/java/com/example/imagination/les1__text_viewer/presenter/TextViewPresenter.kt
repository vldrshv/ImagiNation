package com.example.imagination.les1__text_viewer.presenter

import com.example.imagination.les1__text_viewer.IView
import com.example.imagination.les1__text_viewer.model.TextModel
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class TextViewPresenter() : MvpPresenter<IView>() {
    private val CLASS_TAG = "TextViewPresenter"
    private var textModel: TextModel = TextModel()

    fun initiateConcat(newText: String) {
        concatText(newText)
        setTextToView()
    }

    private fun setTextToView() = viewState.setText(textModel.text)

    private fun concatText(s: String) {
        textModel.text = textModel.text + s
    }

}