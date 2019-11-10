package com.example.imagination.core.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.CompoundButton
import com.example.imagination.AppConfig
import com.example.imagination.R
import com.example.imagination.core.model.SharedPreferencesManager
import com.example.imagination.core.model.database.PhotoDatabase
import com.example.imagination.core.view.ISettingsView
import com.google.android.material.chip.ChipGroup
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class SettingsPresenter(val view: ISettingsView, context: Context) {
    // class vars
    private val CLASS_TAG = "SettingsPresenter"
    private var appSettings: SharedPreferencesManager = SharedPreferencesManager(context)
    var APP_THEME = appSettings.getThemeId()
    private var lastCheckedId = 0
    // db
    private var db: PhotoDatabase = AppConfig.getInstance().getDatabase()
    private var likedPhotoDao = db.getPhotosDao()
    private var photoSourceDao = db.getPhotoSourceDao()
    private lateinit var disposable: Disposable

    fun getCheckedId(chipGroup: ChipGroup) : Int {
        lastCheckedId = if (APP_THEME == R.style.AppTheme)
            R.id.light_mode_theme_selection else
            R.id.dark_mode_theme_selection

        return lastCheckedId
    }

    // todo refactor
    fun onCheckedChanged() : ChipGroup.OnCheckedChangeListener {
        return object : ChipGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: ChipGroup?, checkedId: Int) {
                if (checkedId == -1) {
                    group!!.check(lastCheckedId)
                    return
                }
                if (checkedId == lastCheckedId)
                    return
                val themeId = when (checkedId) {
                    R.id.light_mode_theme_selection -> R.style.AppTheme
                    R.id.dark_mode_theme_selection -> R.style.AppTheme_Dark
                    else -> 0
                }
                lastCheckedId = checkedId
                appSettings.setThemeId(themeId)
                view.reloadActivity(themeId)
            }
        }
    }
    fun onSwitchCheckedChange() : CompoundButton.OnCheckedChangeListener {
        return object: CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                appSettings.setGalleryAutoLoading(isChecked)
                Log.i(CLASS_TAG, appSettings.isGalleryAutoLoading().toString())
            }
        }
    }

    fun getAutoLoadingSetting() = appSettings.isGalleryAutoLoading()

    fun getLastGalleryUpdateDate() : String {
        val dateMills = appSettings.getLastGalleryUpdateDate()
        var date = Date(dateMills)
        return "${date.date}.${date.month + 1}.${date.year + 1900}"
    }

    fun getGalleryCacheSize() = appSettings.getGalleryCacheSize()
    @SuppressLint("CheckResult")
    fun cleanGalleryCache() {
        Completable.fromAction { likedPhotoDao.deletePhotos(false) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            appSettings.setGalleryCacheSize(0)
            view.setGalleryCacheSize()
        }
    }

    fun getLikedPhotosCacheSize() = appSettings.getLikedPhotosCacheSize()
    @SuppressLint("CheckResult")
    fun cleanLikedPhotosCache() {
        Completable.fromAction { likedPhotoDao.deletePhotos(true) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            appSettings.setLikedPhotosCacheSize(0)
            view.setLikedPhotosCacheSize()
        }
    }

}