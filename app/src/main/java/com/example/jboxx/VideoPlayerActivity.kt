package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.WindowManager
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener


class VideoPlayerActivity : Activity() {

    private lateinit var videoView: VideoView
    private lateinit var playButton: ImageView
    private lateinit var rewindButton: ImageView
    private lateinit var forwardButton: ImageView
    private lateinit var videoSeekBar: SeekBar
    private lateinit var timeCurrent: TextView
    private lateinit var timeTotal: TextView
    private lateinit var brightnessSeek: SeekBar
    private lateinit var volumeSeek: SeekBar

    private val handler = Handler(Looper.getMainLooper())
    private var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_video_player)

        val movieName = intent.getStringExtra("movie_name") ?: "default_movie"
        val synopsis = intent.getStringExtra("synopsis") ?: "No synopsis available."
        val movieTitle = intent.getStringExtra("movie_title") ?: "Unknown Title"

        val booknowButton = findViewById<Button>(R.id.booknow)
        val videoTitle = findViewById<TextView>(R.id.videoTitle)

        booknowButton.setOnClickListener {
            val movieTitle = videoTitle.text.toString()
            val intent = Intent(this@VideoPlayerActivity, TicketBookingActivity::class.java)
            intent.putExtra("movie_title", movieTitle)
            startActivity(intent)

        }

        val videoTitleTextView = findViewById<TextView>(R.id.videoTitle)
        videoTitleTextView.text = movieTitle

        val synopsisTextView = findViewById<TextView>(R.id.synopsisTextView)
        synopsisTextView.text = synopsis

        videoView = findViewById(R.id.videoView)
        playButton = findViewById(R.id.playButton)
        rewindButton = findViewById(R.id.rewindButton)
        forwardButton = findViewById(R.id.forwardButton)
        videoSeekBar = findViewById(R.id.videoSeekBar)
        timeCurrent = findViewById(R.id.timeCurrent)
        timeTotal = findViewById(R.id.timeTotal)
        brightnessSeek = findViewById(R.id.brightnessSeek)
        volumeSeek = findViewById(R.id.volumeSeek)

        val uri = Uri.parse("android.resource://${packageName}/raw/$movieName")
        videoView.setVideoURI(uri)

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        videoView.setOnPreparedListener { mp ->
            videoSeekBar.max = videoView.duration
            timeTotal.text = formatTime(videoView.duration)

            val videoWidth = mp.videoWidth
            val videoHeight = mp.videoHeight

            val screenWidth = resources.displayMetrics.widthPixels
            val screenHeight = resources.displayMetrics.heightPixels

            val aspectRatio = videoWidth.toFloat() / videoHeight.toFloat()

            val layoutParams = videoView.layoutParams

            if (aspectRatio > 1) {
                layoutParams.width = screenWidth
                layoutParams.height = (screenWidth / aspectRatio).toInt()
            } else {
                layoutParams.height = screenHeight
                layoutParams.width = (screenHeight * aspectRatio).toInt()
            }

            layoutParams.width = screenWidth
            layoutParams.height = (screenWidth / aspectRatio).toInt()
            videoView.layoutParams = layoutParams

            videoView.start()
            playButton.setImageResource(R.drawable.pause)

            updateSeekBar()
        }

        playButton.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
                playButton.setImageResource(R.drawable.play)
            } else {
                videoView.start()
                playButton.setImageResource(R.drawable.pause)
            }
        }

        rewindButton.setOnClickListener {
            videoView.seekTo(videoView.currentPosition - 5000)
        }

        forwardButton.setOnClickListener {
            videoView.seekTo(videoView.currentPosition + 5000)
        }

        videoSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    videoView.seekTo(progress)
                }
                timeCurrent.text = formatTime(videoView.currentPosition)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        volumeSeek.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        volumeSeek.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
        volumeSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        val layoutParams = window.attributes
        val currentBrightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, 125)
        brightnessSeek.progress = (currentBrightness * 100) / 255
        brightnessSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val brightness = progress / 100.0f
                layoutParams.screenBrightness = brightness
                window.attributes = layoutParams
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    private fun updateSeekBar() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (videoView.isPlaying) {
                    videoSeekBar.progress = videoView.currentPosition
                    timeCurrent.text = formatTime(videoView.currentPosition)
                    handler.postDelayed(this, 500)
                }
            }
        }, 0)
    }

    private fun formatTime(milliseconds: Int): String {
        val minutes = milliseconds / 1000 / 60
        val seconds = (milliseconds / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
