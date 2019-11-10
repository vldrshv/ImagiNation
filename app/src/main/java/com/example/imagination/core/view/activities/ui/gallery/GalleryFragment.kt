package com.example.imagination.core.view.activities.ui.gallery

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.imagination.R
import com.example.imagination.core.presenter.GalleryPresenter
import com.example.imagination.core.view.PhotoView
import com.example.imagination.core.view.activities.SinglePhotoActivity
import com.example.imagination.core.view.recycler.ItemDecoration
import com.example.imagination.core.view.recycler.MyAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class GalleryFragment : MvpAppCompatFragment(), PhotoView {

    private val CLASS_TAG = "GalleryFragment"

    private lateinit var root: View
    private lateinit var photoRecyclerView: RecyclerView
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var autoSyncMessageLayout: LinearLayoutCompat
    private lateinit var btnCloseAutoSyncMessage: Button

    @InjectPresenter
    lateinit var galleryPresenter: GalleryPresenter

    @ProvidePresenter
    fun provideGalleryPresenter(): GalleryPresenter {

        return GalleryPresenter(context!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_gallery, container, false)

        initUI()
        initRecycleView()
        initRefreshing()

        return root
    }

    private fun initUI() {
        photoRecyclerView = root.findViewById(R.id.photo_recycle_view)
        refreshLayout = root.findViewById(R.id.refresh_layout)
        progressBar = root.findViewById(R.id.progress_bar)
        autoSyncMessageLayout = root.findViewById(R.id.auto_sync_message_layout)
        btnCloseAutoSyncMessage = root.findViewById(R.id.auto_sync_message_btn_close)

        autoSyncMessageLayout.visibility = if (galleryPresenter.isAutoSyncEnabled()) View.GONE else View.VISIBLE
        btnCloseAutoSyncMessage.setOnClickListener { autoSyncMessageLayout.visibility = View.GONE }
    }

    private fun initRecycleView() {
        val spanCount = if(isPortraitOrientation()) 2 else 3

        photoRecyclerView.layoutManager = GridLayoutManager(context, spanCount)
        photoRecyclerView.addOnScrollListener(galleryPresenter.recyclerViewEndPageListener())
        photoRecyclerView.addItemDecoration(ItemDecoration(4))

        val size = Point()
        activity!!.windowManager.defaultDisplay.getSize(size)
        photoRecyclerView.adapter = MyAdapter(galleryPresenter, size, isPortraitOrientation())
    }

    private fun isPortraitOrientation(): Boolean {
        return this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

    private fun initRefreshing() {
        refreshLayout.setOnRefreshListener(galleryPresenter.recyclerViewRefreshListener())
    }

    override fun openImage(imageId: Int) {
        val intent: Intent = Intent(context, SinglePhotoActivity::class.java)
        intent.putExtra("imageId", imageId)
        startActivity(intent)
    }

    override fun notifyDataChanged() {
        val myAdapter = photoRecyclerView.adapter
        myAdapter!!.notifyDataSetChanged()
    }

    override fun stopRefreshing() {
        refreshLayout.isRefreshing = false
    }

    override fun showLoading(isShown: Boolean) {
        progressBar.visibility = if (isShown) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(CLASS_TAG, ":: SVAE CACHE")
        galleryPresenter.saveCache()
    }
}
