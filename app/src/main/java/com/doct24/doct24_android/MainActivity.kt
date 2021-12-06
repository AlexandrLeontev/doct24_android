package com.doct24.doct24_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat.setBackground
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.doct24.doct24_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.mainBottomBar
        navController = Navigation.findNavController(this, R.id.container)

        NavigationUI.setupWithNavController(navView, navController)
    }

    fun setImg(patientProfileBkg: Int) {
       binding.constraintBackground.setBackgroundResource(patientProfileBkg)
    }
    fun delImg(){
        binding.constraintBackground.setBackgroundResource(0)
    }

}