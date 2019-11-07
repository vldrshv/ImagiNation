package com.example.imagination.core.view.recycler

import androidx.recyclerview.widget.RecyclerView
import android.graphics.Rect
import android.view.View


class ItemDecoration(private var space: Int) : RecyclerView.ItemDecoration() {
    private val CLASS_TAG = "ItemDecoration"

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space
        outRect.top = space
    }
}