package com.example.imagination.text_viewer

interface Interface {
    interface View {
        fun getText(): String
        fun setText(text: String)
    }
    interface Presenter {
        fun initiateConcat()

        fun getTextFromView(): String
        fun setTextToView()
        fun concatText(s: String)
    }
}