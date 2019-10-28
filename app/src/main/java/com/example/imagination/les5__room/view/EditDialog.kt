package com.example.imagination.les5__room.view

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.content.DialogInterface
import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.example.imagination.R
import com.example.imagination.les5__room.UserPresenter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText


class EditDialog(val activity: Activity, val presenter: UserPresenter) : DialogFragment() {
    private val CLASS_TAG = "EditDialog"


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        val rootView = inflater.inflate(com.example.imagination.R.layout.dialog_edit_user, null)

        val username = rootView.findViewById(R.id.username) as EditText
        username.setText(presenter.getSelectedUserName())

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(rootView)//inflater.inflate(com.example.imagination.R.layout.dialog_edit_user, null))
            // Add action buttons
            .setPositiveButton("Accept",
                DialogInterface.OnClickListener { dialog, id ->
                    presenter.saveEditedUser(username.text.toString())
                })
            .setNegativeButton("Decline",
                DialogInterface.OnClickListener { dialog, id ->
                    this@EditDialog.dialog!!.cancel()
                })
        return builder.create()
    }
}