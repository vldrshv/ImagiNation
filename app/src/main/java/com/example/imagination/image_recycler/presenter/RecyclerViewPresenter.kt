package com.example.imagination.image_recycler.presenter

import com.example.imagination.image_recycler.model.PhotoModel
import com.example.imagination.image_recycler.view.IViewHolder


class RecyclerViewPresenter {
    private var presenter: MainPresenter? = null

    init {
        presenter = MainPresenter()
    }

    fun getPresenter() = presenter!!

    class MainPresenter : IRecyclerViewPresenter {
        private val photoPresenter = PhotoPresenter()
        private val photoList: List<PhotoModel> = photoPresenter.getPhotoList()

        override fun bindView(iViewHolder: IViewHolder) {
            val position = iViewHolder.getPos()
            iViewHolder.setImageOne(photoList[position].imageId)
        }

        override fun getItemCount(): Int {
            return photoList.size
        }
    }
}