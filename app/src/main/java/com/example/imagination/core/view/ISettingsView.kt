package com.example.imagination.core.view

interface ISettingsView {
    fun reloadActivity(themeId: Int)
    fun setGalleryCacheSize()
    fun setLikedPhotosCacheSize()
}
