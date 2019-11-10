package com.example.imagination.core.view.activities.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.imagination.R
import com.example.imagination.core.presenter.SettingsPresenter
import com.example.imagination.core.view.ISettingsView
import com.example.imagination.core.view.activities.MainActivity
import com.google.android.material.chip.ChipGroup
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(), ISettingsView {
    private val CLASS_TAG = "SettingsFragment"
    lateinit var root: View
    private lateinit var presenter: SettingsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_settings, container, false)

        presenter = SettingsPresenter(this, context!!)

        initThemeSelector()
        initAutoSyncSelector()

        setLastGalleryUpdateDate()
        setGalleryCacheSettings()
        setLikedPhotosCacheSettings()

        return root
    }

    private fun initThemeSelector() {
        val themeModeSelection = root.findViewById<ChipGroup>(R.id.theme_mode_selection)
        setCheckedSelector(themeModeSelection)
        themeModeSelection.setOnCheckedChangeListener(presenter.onCheckedChanged())
    }
    private fun initAutoSyncSelector() {
        val reloadGallerySwitcher = root.findViewById<SwitchMaterial>(R.id.reloadGallerySwitcher)
        setSwitchSelector(reloadGallerySwitcher)
        reloadGallerySwitcher.setOnCheckedChangeListener(presenter.onSwitchCheckedChange())

    }

    private fun setLastGalleryUpdateDate() {
        val lastGalleryUpdateDate = root.findViewById<TextView>(R.id.last_gallery_update_date)
        lastGalleryUpdateDate.text = presenter.getLastGalleryUpdateDate()
    }
    private fun setGalleryCacheSettings() {
        setGalleryCacheSize()
        val cleanGalleryCacheBtn = root.findViewById(R.id.gallery_cache_size_clean_btn) as Button
        cleanGalleryCacheBtn.setOnClickListener { presenter.cleanGalleryCache() }
    }
    private fun setLikedPhotosCacheSettings() {
        setLikedPhotosCacheSize()
        val cleanLikedPhotosCacheBtn = root.findViewById(R.id.liked_photos_cache_size_clean_btn) as Button
        cleanLikedPhotosCacheBtn.setOnClickListener { presenter.cleanLikedPhotosCache() }
    }


    private fun setCheckedSelector(chipGroup: ChipGroup) {
        chipGroup.check(presenter.getCheckedId(chipGroup))
    }
    private fun setSwitchSelector(switchMaterial: SwitchMaterial) {
        switchMaterial.isChecked = presenter.getAutoLoadingSetting()
    }

    override fun reloadActivity(themeId: Int) {
        val intent = Intent(context, MainActivity::class.java)
        activity!!.finish()
        startActivity(intent)
    }

    override fun setGalleryCacheSize() {
        val galleryCacheTv = root.findViewById(R.id.gallery_cache_size_tv) as TextView
        galleryCacheTv.text = "${presenter.getGalleryCacheSize()} images"
    }

    override fun setLikedPhotosCacheSize() {
        val likedPhotosCacheTv = root.findViewById(R.id.liked_photos_cache_size_tv) as TextView
        likedPhotosCacheTv.text = "${presenter.getLikedPhotosCacheSize()} images"
    }
}
