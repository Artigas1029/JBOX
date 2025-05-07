package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jboxx.playbackspeed.SpeedAdapter

class PlaybackSpeedActivity : Activity() {

//    private val speeds = listOf(
//        "0.25", "0.50", "0.75", "Normal", "1.25", "1.50", "1.75", "2.00"
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playback_speed)

        val currentPlaybackSpeed = intent.getStringExtra("CURRENT_SPEED") ?: "Normal"

        val speeds = listOf("0.5x", "0.50x", "0.75x", "Normal", "1.25x", "1.5x", "1.75x", "2x")
        val listView = findViewById<ListView>(R.id.speedListView)

        val adapter = SpeedAdapter(this, speeds, currentPlaybackSpeed)
        listView.adapter = adapter

        val selectedIndex = speeds.indexOf(currentPlaybackSpeed)
        listView.setItemChecked(selectedIndex, true)

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedSpeed = speeds[position]
            val resultIntent = Intent()
            resultIntent.putExtra("SELECTED_SPEED", selectedSpeed)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}