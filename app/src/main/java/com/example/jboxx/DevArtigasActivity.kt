package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DevArtigasActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_artigas)

        val aikenbutton = findViewById<ImageView>(R.id.aiken)
        val jacobbutton = findViewById<ImageView>(R.id.tapere)
        val johannabutton = findViewById<ImageView>(R.id.johanna)
        val louiebutton = findViewById<ImageView>(R.id.louie)
        val closebutton = findViewById<ImageView>(R.id.close)

        aikenbutton.setOnClickListener {
            val intent = Intent(this, DevArtigasActivity::class.java)
            startActivity(intent)
            finish()
        }
        jacobbutton.setOnClickListener {
            val intent = Intent(this, DevTapereActivity::class.java)
            startActivity(intent)
            finish()
        }
        johannabutton.setOnClickListener {
            val intent = Intent(this, DevJohannaActivity::class.java)
            startActivity(intent)
            finish()
        }
        louiebutton.setOnClickListener {
            val intent = Intent(this, DevLouieActivity::class.java)
            startActivity(intent)
            finish()
        }
        closebutton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}