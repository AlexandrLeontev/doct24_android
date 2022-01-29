package com.doct24.doct24_android.view.authorization

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.doct24.doct24_android.R

class DownloadActivity : AppCompatActivity() {

    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)

        handler.postDelayed({
            startActivity(Intent(this@DownloadActivity, OnboardingFragmentOne::class.java))
            finish()
        }, 2000)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}