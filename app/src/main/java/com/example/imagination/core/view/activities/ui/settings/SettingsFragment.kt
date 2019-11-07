package com.example.imagination.core.view.activities.ui.settings

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.imagination.R
import com.example.imagination.core.model.database.AppDatabaseConfig
import com.example.imagination.core.view.activities.MainActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SettingsFragment : Fragment(), ChipGroup.OnCheckedChangeListener {
    private val CLASS_TAG = "SettingsFragment"
    lateinit var root: View
    private val appSettings = AppDatabaseConfig.getInstance().getSettings()
    private var lastCheckedId = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_settings, container, false)
        val themeModeSelection = root.findViewById<ChipGroup>(R.id.theme_mode_selection)
        setCheckedSelector(themeModeSelection)
        themeModeSelection.setOnCheckedChangeListener(this)
        return root
    }

    private fun setCheckedSelector(chipGroup: ChipGroup) {
        val mode = appSettings.getInt("themeId", R.style.AppTheme)
        if (mode == R.style.AppTheme) {
            chipGroup.check(R.id.light_mode_theme_selection)
            lastCheckedId = R.id.light_mode_theme_selection
        }
        else {
            chipGroup.check(R.id.dark_mode_theme_selection)
            lastCheckedId = R.id.dark_mode_theme_selection
        }
    }

    override fun onCheckedChanged(group: ChipGroup?, checkedId: Int) {
        Log.i(CLASS_TAG, "$checkedId")
        if (checkedId == -1) {
            group!!.check(lastCheckedId)
            return
        }
        if (checkedId == lastCheckedId)
            return
        var themeId = when(checkedId) {
            R.id.light_mode_theme_selection -> R.style.AppTheme
            R.id.dark_mode_theme_selection -> R.style.AppTheme_Dark
            else -> 0
        }
        lastCheckedId = checkedId
        reloadActivity(themeId)
    }

    private fun reloadActivity(themeId: Int) {
        val intent = Intent(context, MainActivity::class.java)
        val editor = appSettings.edit()
        editor.putInt("themeId", themeId)
        editor.apply()
        intent.putExtra("themeId", themeId)
        activity!!.finish()
        startActivity(intent)
    }
}
