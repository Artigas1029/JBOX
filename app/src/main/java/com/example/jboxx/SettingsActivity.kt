package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backbutton = findViewById<ImageView>(R.id.backhome)
        val devpagebutton = findViewById<LinearLayout>(R.id.devpage)

        backbutton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

        devpagebutton.setOnClickListener {
            val intent = Intent(this, DevJohannaActivity::class.java)
            startActivity(intent)
        }
    }
}