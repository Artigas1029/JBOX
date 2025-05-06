package com.example.jboxx

import android.app.Activity
import android.media.AudioManager
import android.os.Bundle
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AudioSubtitlesActivity : Activity() {

    private var selectedAudio: String = ""
    private var selectedSubtitle: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_subtitles)

        val seekBar = findViewById<SeekBar>(R.id.seekBarVolume)
        val volumeLevelText = findViewById<TextView>(R.id.volumeLevelText)
        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        seekBar.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        seekBar.progress = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
                volumeLevelText.text = "Volume: $progress"
            }

            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })

        val radenglishAudio = findViewById<RadioButton>(R.id.rbAudioEnglish)
        val radkoreanAudio = findViewById<RadioButton>(R.id.rbAudioKorean)
        val radfilipinoAudio = findViewById<RadioButton>(R.id.rbAudioFilipino)

        fun selectAudio(language: String, checked: RadioButton) {
            selectedAudio = language
            showToast("Audio set to $language")
            radenglishAudio.isChecked = false
            radkoreanAudio.isChecked = false
            radfilipinoAudio.isChecked = false
            checked.isChecked = true
        }
        radenglishAudio.setOnClickListener {
            selectAudio("English", radenglishAudio)
            showToast("Subtitle set to $selectedAudio")
        }
        radkoreanAudio.setOnClickListener {
            selectAudio("Korean",  radkoreanAudio)
            showToast("Subtitle set to $selectedAudio")
        }
        radfilipinoAudio.setOnClickListener {
            selectAudio("Filipino", radfilipinoAudio)
            showToast("Subtitle set to $selectedAudio")
        }

        val radenglishSubtitle = findViewById<RadioButton>(R.id.rbSubEnglish)
        val radkoreanSubtitle = findViewById<RadioButton>(R.id.rbSubKorean)
        val radfilipinoSubtitle = findViewById<RadioButton>(R.id.rbSubFilipino)

        fun selectSubtitle(language: String, checked: RadioButton) {
            selectedAudio = language
            showToast("Subtitle set to $language")
            radenglishSubtitle.isChecked = false
            radkoreanSubtitle.isChecked = false
            radfilipinoSubtitle.isChecked = false
            checked.isChecked = true
        }
        radenglishSubtitle.setOnClickListener {
            selectSubtitle("English", radenglishSubtitle)
            showToast("Subtitle set to $selectedAudio")
        }
        radkoreanSubtitle.setOnClickListener {
            selectSubtitle("Korean",  radkoreanSubtitle)
            showToast("Subtitle set to $selectedAudio")
        }
        radfilipinoSubtitle.setOnClickListener {
            selectSubtitle("Filipino", radfilipinoSubtitle)
            showToast("Subtitle set to $selectedAudio")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
