package com.example.imagination.core.view.activities.ui.dashboard

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.imagination.R
import com.example.imagination.core.presenter.BasePhotoPresenter
import com.example.imagination.core.presenter.LikedPhotoPresenter
import com.example.imagination.core.presenter.RecyclerViewPresenter
import com.example.imagination.core.view.PhotoView
import com.example.imagination.core.view.activities.SinglePhotoActivity
import com.example.imagination.core.view.recycler.ItemDecoration
import com.example.imagination.core.view.recycler.MyAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class LikedGalleryFragment : MvpAppCompatFragment(), PhotoView {

    private lateinit var root: View
    private lateinit var photoRecyclerView: RecyclerView
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar

    @InjectPresenter
    lateinit var presenter: LikedPhotoPresenter

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
    }

    private fun initRecycleView() {
        // todo make no resize
        val spanCount = if(isPortraitOrientation()) 1 else 2

        photoRecyclerView.layoutManager = GridLayoutManager(context, spanCount)
        photoRecyclerView.addOnScrollListener(presenter.recyclerViewEndPageListener())
        photoRecyclerView.addItemDecoration(ItemDecoration(0))

        val size = Point()
        activity!!.windowManager.defaultDisplay.getSize(size)
        photoRecyclerView.adapter = MyAdapter(presenter, size, isPortraitOrientation())
    }

    private fun isPortraitOrientation(): Boolean {
        return this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

    private fun initRefreshing() {
        refreshLayout.setOnRefreshListener(presenter.recyclerViewRefreshListener())
    }

    override fun showToast(s: String) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show()
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

    override fun onResume() {
        super.onResume()
        notifyDataChanged()
    }
}
