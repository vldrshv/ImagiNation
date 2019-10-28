package com.example.imagination.les5__room.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagination.R
import com.example.imagination.les5__room.UserPresenter
import kotlinx.android.synthetic.main.activity_room.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class RoomActivity : MvpAppCompatActivity(), IView {

    @InjectPresenter
    lateinit var presenter: UserPresenter// = UserPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        addUser.setOnClickListener(presenter.addUserListener())
        initRecycler()
    }

    private fun initRecycler() {
        lvUserList.layoutManager = LinearLayoutManager(this)
        lvUserList.adapter = UserAdapter(presenter)
    }

    override fun dataChanged() {
        lvUserList.adapter!!.notifyDataSetChanged()
    }

    override fun showLoading(flag: Boolean) {
        progressBar.visibility = if(flag) View.VISIBLE else View.INVISIBLE
    }

    override fun showEditDialog() {
        val dialog = EditDialog(this, presenter)
        dialog.show(supportFragmentManager, "edit")
    }


}
