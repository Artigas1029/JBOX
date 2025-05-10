    package com.example.jboxx

<<<<<<< Updated upstream
    import android.app.Activity
    import android.content.Intent
    import android.net.Uri
    import android.os.Bundle
    import android.widget.ImageView
    import android.widget.LinearLayout
    import android.widget.TextView
=======
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
>>>>>>> Stashed changes

    class SettingsActivity : Activity() {
        private var currentPlaybackSpeed: String = "Normal"
        private lateinit var playbackSpeedValue: TextView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_settings)

            val backbutton = findViewById<ImageView>(R.id.backhome)
            val devpagebutton = findViewById<LinearLayout>(R.id.devpage)
            val playbackSpeedLayout = findViewById<LinearLayout>(R.id.playbackSpeedLayout)
            val videoQualityLayout = findViewById<LinearLayout>(R.id.VideoQualityyy)
            val internetSpeedLayout = findViewById<LinearLayout>(R.id.internetSpeedLayout)

            // Bind the TextView
            playbackSpeedValue = findViewById(R.id.playbackSpeedValue)
            playbackSpeedValue.text = currentPlaybackSpeed

            backbutton.setOnClickListener {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }

            devpagebutton.setOnClickListener {
                startActivity(Intent(this, DevJohannaActivity::class.java))
            }

            playbackSpeedLayout.setOnClickListener {
                val intent = Intent(this, PlaybackSpeedActivity::class.java)
                intent.putExtra("CURRENT_SPEED", currentPlaybackSpeed)
                startActivityForResult(intent, 101)
            }

            videoQualityLayout.setOnClickListener {
                val intent = Intent(this, VideoQualityActivity::class.java)
                intent.putExtra("CURRENT_QUALITY", "1080p") // Optional: pass current quality
                startActivityForResult(intent, 102)
            }
            //internet speed checking nni shaaa dol
            internetSpeedLayout.setOnClickListener {
                // Open Ookla Speedtest website
                val speedTestIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://www.speedtest.net")
                    // Optional: if you want to try opening in the Speedtest by Ookla app if installed
                    // setPackage("org.zwanoo.android.speedtest")
                }

                // Verify that there's an activity to handle the intent
                if (speedTestIntent.resolveActivity(packageManager) != null) {
                    startActivity(speedTestIntent)
                } else {
                    // Fallback: open in browser if no app can handle it
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.speedtest.net")))
                }
            }
        }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
                val selectedSpeed = data?.getStringExtra("SELECTED_SPEED") ?: "Normal"
                currentPlaybackSpeed = selectedSpeed
                playbackSpeedValue.text = selectedSpeed
            }else if (requestCode == 102 && resultCode == Activity.RESULT_OK) {
                val selectedQuality = data?.getStringExtra("SELECTED_QUALITY") ?: "1080p"
                val qualityTextView = findViewById<TextView>(R.id.video_quality_textview)
                qualityTextView.text = selectedQuality
            }
        }
    }