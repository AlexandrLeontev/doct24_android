package com.doct24.doct24_android.view.authorization

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.doct24.doct24_android.MainActivity
import com.doct24.doct24_android.R

class DownloadFragment : AppCompatActivity() {

    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_download)

        handler.postDelayed({
            startActivity(Intent(this@DownloadFragment, MainActivity::class.java))
            finish()
        }, 2000)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}