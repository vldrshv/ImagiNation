package com.example.imagination.core.view.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.imagination.R
import com.example.imagination.AppConfig


class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    private val appSettings = AppConfig.getInstance().getSettings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(appSettings.getThemeId())
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

}
