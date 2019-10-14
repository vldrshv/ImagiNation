package com.example.imagination.les1__image_recycler.presenter

import com.example.imagination.R
import com.example.imagination.les1__image_recycler.model.ClickedPhoto
import com.example.imagination.les1__image_recycler.model.PhotoModel
import com.example.imagination.les1__image_recycler.view.IViewHolder
import com.example.imagination.les1__image_recycler.view.PhotoView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class RecyclerViewPresenter : IRecyclerViewPresenter, MvpPresenter<PhotoView>() {

    private var photoList: ArrayList<PhotoModel> = arrayListOf()
    private var clickedPhoto: ClickedPhoto = ClickedPhoto()

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

        viewState.showToast("${clickedPhoto.position}")
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    private fun setPosition(pos: Int) {
        clickedPhoto.position = pos
    }

    override fun clicked(pos: Int) {
        setPosition(pos)
        viewState.showToast("$pos")
    }
}