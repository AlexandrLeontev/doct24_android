package com.doct24.doct24_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat.setBackground
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.doct24.doct24_android.databinding.ActivityMainBinding
import com.doct24.doct24_android.view.hide
import com.doct24.doct24_android.view.show
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController
//    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.mainBottomBar
        navController = Navigation.findNavController(this, R.id.container)

        NavigationUI.setupWithNavController(navView, navController)

//        скрываем боттом меню https://coderoad.ru/54087740/как-скрыть-BottomNavigationView-на-android-navigation-lib

        lifecycleScope.launchWhenResumed {
            navController.addOnDestinationChangedListener {  _, destination, _ ->
                when (destination.id) {
                    R.id.PatientDataFragment -> mainBottomBar.hide()
                    else -> mainBottomBar.show()
                }
            }
        }

    }
}