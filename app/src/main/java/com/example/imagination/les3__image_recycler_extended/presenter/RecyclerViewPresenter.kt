package com.example.imagination.les3__image_recycler_extended.presenter

import com.example.imagination.R
import com.example.imagination.les3__image_recycler_extended.model.ClickedPhoto
import com.example.imagination.les3__image_recycler_extended.model.PhotoModel
import com.example.imagination.les3__image_recycler_extended.view.IViewHolder
import com.example.imagination.les3__image_recycler_extended.view.PhotoView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class RecyclerViewPresenter : IRecyclerViewPresenter, MvpPresenter<PhotoView>() {

    private var photoList: ArrayList<PhotoModel> = arrayListOf()

    init {
        for (i in 0..30) {
            photoList.add(PhotoModel(R.drawable.ic_launcher_foreground))
        }
    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]
        iViewHolder.setImageOne(photoModel.imageId)
        iViewHolder.setBackground(photoModel.backgroundColor)

    }

    override fun getItemCount(): Int {
        return photoList.size
    }


    override fun clicked(pos: Int) {
        viewState.showToast("$pos")
        val img = photoList[pos]
        viewState.openImage(img.imageId, img.backgroundColor)
    }
}