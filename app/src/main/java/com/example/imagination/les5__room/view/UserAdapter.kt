package com.example.imagination.les5__room.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imagination.R
import com.example.imagination.les5__room.UserPresenter

class UserAdapter(var presenter: UserPresenter) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private val CLASS_TAG = "UserAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_grid, parent, false)
        return MyViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return presenter.getItemCount()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        presenter.bindView(holder)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class MyViewHolder(itemView: View, var presenter: UserPresenter) :
        RecyclerView.ViewHolder(itemView), IViewHolder {
        private val CLASS_TAG = "MyViewHolder"

        private var tvUserName = itemView.findViewById(R.id.tvUserName) as TextView
        private var editBtn = itemView.findViewById(R.id.editBtn) as Button
        private var deleteBtn = itemView.findViewById(R.id.deleteBtn) as Button

        init {
            editBtn.setOnClickListener { editUser() }
            deleteBtn.setOnClickListener { deleteUser() }
        }

        private fun editUser() {
            presenter.editUser(position)
        }
        private fun deleteUser() {
            presenter.deleteUser(position)
        }

        override fun getPos(): Int = position

        override fun setName(name: String) {
            tvUserName.text = name
        }

    }
}