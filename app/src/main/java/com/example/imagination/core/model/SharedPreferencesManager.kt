package com.example.imagination.core.model

import android.content.Context
import android.content.SharedPreferences
import com.example.imagination.R
import java.util.*

class SharedPreferencesManager(val context: Context) {
    private val CLASS_TAG = "SharedPreferencesManager"
    private var sp: SharedPreferences = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)

    // theme settings
    fun getThemeId() = sp.getInt("themeId", R.style.AppTheme)
    fun setThemeId(themeId: Int){
        val editor = sp.edit()
        editor.putInt("themeId", themeId)
        editor.apply()
    }

    // gallery load settings
    fun isGalleryAutoLoading() = sp.getBoolean("isGalleryAutoLoading", true)
    fun setGalleryAutoLoading(flag: Boolean = true) {
        val editor = sp.edit()
        editor.putBoolean("isGalleryAutoLoading", flag)
        editor.apply()
    }
    fun setLastGalleryUpdateDate() {
        val dateMills = System.currentTimeMillis()
        val editor = sp.edit()
        editor.putLong("lastGalleryUpdateDate", dateMills)
        editor.apply()
    }
    fun getLastGalleryUpdateDate() = sp.getLong("lastGalleryUpdateDate", 0)

    fun setGalleryCacheSize(size: Int) {
        val editor = sp.edit()
        editor.putInt("galleryCacheSize", size)
        editor.apply()
    }
    fun getGalleryCacheSize() = sp.getInt("galleryCacheSize", 0)
    fun setLikedPhotosCacheSize(size: Int) {
        val editor = sp.edit()
        editor.putInt("likedPhotosCacheSize", size)
        editor.apply()
    }
    fun getLikedPhotosCacheSize() = sp.getInt("likedPhotosCacheSize", 0)


}