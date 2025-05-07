package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class VideoQualityActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_quality)

        findViewById<Button>(R.id.btn1080p).setOnClickListener {
            returnResult("1080p")
        }

        findViewById<Button>(R.id.btn720p).setOnClickListener {
            returnResult("720p")
        }

        findViewById<Button>(R.id.btn480p).setOnClickListener {
            returnResult("480p")
        }
        findViewById<Button>(R.id.btn360p).setOnClickListener {
            returnResult("360p")
        }

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
    private fun returnResult(quality: String) {
        val resultIntent = Intent()
        resultIntent.putExtra("SELECTED_QUALITY", quality)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}