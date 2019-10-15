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
//    private var clickedPhoto: ClickedPhoto = ClickedPhoto()

    init {
        for (i in 0..30) {
            photoList.add(PhotoModel(R.drawable.ic_launcher_foreground))
//            photoList.add(PhotoModel(android.R.drawable.ic_delete))
//            photoList.add(PhotoModel(android.R.drawable.ic_dialog_alert))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_edit))
//            photoList.add(PhotoModel(android.R.drawable.ic_dialog_dialer))
//            photoList.add(PhotoModel(android.R.drawable.ic_input_add))
//            photoList.add(PhotoModel(android.R.drawable.ic_dialog_email))
//            photoList.add(PhotoModel(android.R.drawable.ic_dialog_info))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_add))
//            photoList.add(PhotoModel(android.R.drawable.ic_lock_idle_lock))
//            photoList.add(PhotoModel(android.R.drawable.ic_search_category_default))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_save))
//            photoList.add(PhotoModel(android.R.drawable.ic_input_get))
//            photoList.add(PhotoModel(android.R.drawable.ic_lock_silent_mode))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_agenda))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_zoom))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_week))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_today))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_upload_you_tube))
//            photoList.add(PhotoModel(android.R.drawable.ic_menu_close_clear_cancel))
        }
    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]
        iViewHolder.setImageOne(photoModel.imageId)
        iViewHolder.setBackground(photoModel.backgroundColor)

//        viewState.showToast("${clickedPhoto.position}")
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

//    private fun setPosition(pos: Int) {
//        clickedPhoto.position = pos
//    }

    override fun clicked(pos: Int) {
//        setPosition(pos)
        viewState.showToast("$pos")
        openImage(photoList[pos])
    }

    fun openImage(photoModel: PhotoModel) {

    }
}