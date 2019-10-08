package com.example.imagination.image_recycler.presenter

import com.example.imagination.R
import com.example.imagination.image_recycler.model.PhotoModel
import com.example.imagination.image_recycler.view.IViewHolder

class RecyclerViewPresenter : IRecyclerViewPresenter {

    private var photoList: ArrayList<PhotoModel> = arrayListOf()

    init {
        var n = 20
        while (n-- != 0)
            photoList.add(PhotoModel(R.drawable.ic_launcher_foreground))

    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        iViewHolder.setImageOne(photoList[position].imageId)
        if (position % 5 == 0)
            iViewHolder.setGrayBackground()
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}