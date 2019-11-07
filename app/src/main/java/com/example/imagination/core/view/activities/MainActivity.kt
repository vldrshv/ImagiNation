package com.example.imagination.core.view.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.imagination.R
import android.view.WindowManager
import com.example.imagination.core.model.database.AppDatabaseConfig


class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    private val appSettings = AppDatabaseConfig.getInstance().getSettings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val themeId = appSettings.getInt("themeId", R.style.AppTheme)
        //val themeId = intent.getIntExtra("themeId", R.style.AppTheme)
        setTheme(themeId)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

}
