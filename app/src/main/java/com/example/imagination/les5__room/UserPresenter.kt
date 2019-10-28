package com.example.imagination.les5__room

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import com.example.imagination.les5__room.database.AppDatabase
import com.example.imagination.les5__room.database.User
import com.example.imagination.les5__room.database.UserDao
import com.example.imagination.les5__room.database.UserDatabase
import com.example.imagination.les5__room.view.IView
import com.example.imagination.les5__room.view.IViewHolder
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UserPresenter : MvpPresenter<IView>() {
    private val CLASS_TAG = "UserPresenter"

    private var db: UserDatabase = AppDatabase.getInstance().getDatabase()
    private var userDao: UserDao = db.userDao()

    private lateinit var disposable: Disposable

    private var userList: List<User> = arrayListOf()
    private var _position: Int = 0

    init {
        getData()
    }

    fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = userList[position]

        iViewHolder.setName(photoModel.name)
    }

    fun getItemCount(): Int {
        return userList.size
    }

    fun getSelectedUserName() = userList[_position].name

    fun deleteUser(position: Int) {
        _position = position
        deleteData()
    }

    fun editUser(position: Int) {
        _position = position
        viewState.showEditDialog()
        Log.i(CLASS_TAG, "editUser($_position)")
    }

    fun saveEditedUser(newName: String) {
        var user = userList[_position]
        user.name = newName
        updateData(user)
    }

    fun addUserListener(): View.OnClickListener {
        return View.OnClickListener {
            viewState.showLoading(true)
            insertData()
            notifyDataSetChanged()
        }
    }

    private fun notifyDataSetChanged() {
        viewState.showLoading(true)
        viewState.dataChanged()
    }

    private fun getData() {
        disposable = userDao.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val list = userList as ArrayList
                list.clear()
                list.addAll(it)
                notifyDataSetChanged()
                viewState.showLoading(false)
            }
    }
    @SuppressLint("CheckResult")
    private fun insertData() {
        Completable.fromAction { userDao.insert(User()) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { viewState.showLoading(false) },
                { e: Throwable -> e.printStackTrace() }
            )
    }
    @SuppressLint("CheckResult")
    private fun deleteData(){
        Completable.fromAction { userDao.delete(userList[_position]) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {
                    viewState.showLoading(false)
                },
                { e: Throwable -> e.printStackTrace() }
            )
    }
    @SuppressLint("CheckResult")
    private fun updateData(user: User){
        Completable.fromAction { userDao.update(user) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe (
                { viewState.showLoading(false) },
                { e: Throwable -> e.printStackTrace() }
            )
    }
    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}