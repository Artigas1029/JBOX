package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditProfileActivity : Activity() {

    private lateinit var profileImage: ImageView
    private var currentIconRes: Int = R.drawable.profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        profileImage = findViewById(R.id.profile_image)
        val backButton = findViewById<ImageView>(R.id.imageview_back)
        val saveText = findViewById<TextView>(R.id.save_text)

        val prefs = getSharedPreferences("ProfilePrefs", MODE_PRIVATE)
        currentIconRes = prefs.getInt(
            "selected_icon",
            intent.getIntExtra("SELECTED_ICON", R.drawable.profile)
        )
        profileImage.setImageResource(currentIconRes)

        profileImage.setOnClickListener {
            startActivity(Intent(this, ChooseIconActivity::class.java))
        }

        saveText.setOnClickListener {
            prefs.edit().putInt("selected_icon", currentIconRes).apply()
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        val chosen = intent.getIntExtra("SELECTED_ICON", -1)
        if (chosen != -1) {
            currentIconRes = chosen
            profileImage.setImageResource(chosen)
            intent.removeExtra("SELECTED_ICON")
        }
    }
}
