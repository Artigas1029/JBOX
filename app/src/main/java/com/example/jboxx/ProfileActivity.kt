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

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val prefs = getSharedPreferences("ProfilePrefs", MODE_PRIVATE)
        val savedIconRes = prefs.getInt("selected_icon", R.drawable.profile)
        profileImage.setImageResource(savedIconRes)

        val historyButton = findViewById<LinearLayout>(R.id.historyDashboard)
        val languageButton = findViewById<LinearLayout>(R.id.languageDashboard)
        val subtitleButton = findViewById<LinearLayout>(R.id.subtitleDashboard)
        val editProfileButton = findViewById<ImageView>(R.id.edit_icon)
        val backButton = findViewById<ImageView>(R.id.back)

        historyButton.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
            finish()
        }
        languageButton.setOnClickListener {
            startActivity(Intent(this, DisplayLanguageActivity::class.java))
            finish()
        }
        subtitleButton.setOnClickListener {
            startActivity(Intent(this, AudioSubtitlesActivity::class.java))
            finish()
        }
        editProfileButton.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
            finish()
        }
        backButton.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
    }
}
