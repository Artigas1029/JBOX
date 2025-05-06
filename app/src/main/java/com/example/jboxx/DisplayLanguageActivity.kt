package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jboxx.data.Language
import com.example.jboxx.history.LanguageCustomListViewAdapter
import java.util.Locale

class DisplayLanguageActivity : Activity() {

    private lateinit var adapter: LanguageCustomListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_language)

        val closeButton = findViewById<ImageView>(R.id.close)
        val listView = findViewById<ListView>(R.id.language_list)

        val languageList = listOf(
            Language("English (US)", "en"),
            Language("Chinese Traditional", "zh"),
            Language("Arabic", "ar"),
            Language("Japanese (こんにちは)", "ja"),
            Language("English (UK)", "en-rGB"),
            Language("Acholi", "ach"),
            Language("Asturian", "ast"),
            Language("Filipino", "fil"),
            Language("Italian", "it"),
            Language("Latin", "la"),
            Language("Espanol (Argentina)", "es-rAR"),
            Language("French", "fr"),
            Language("Russian (Привет)", "ru")
        )

        val sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
        val selectedLangCode = sharedPreferences.getString("App_Lang", "en") ?: "en"

        adapter = LanguageCustomListViewAdapter(
            this,
            languageList,
            selectedLangCode
        ) { language ->
            val locale = Locale(language.code)
            Locale.setDefault(locale)

            val config = Configuration()
            config.setLocale(locale)
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

            val editor = sharedPreferences.edit()
            editor.putString("App_Lang", language.code)
            editor.apply()

            adapter.updateSelectedLang(language.code)

            Toast.makeText(this, "${language.name} selected", Toast.LENGTH_SHORT).show()
        }

        listView.adapter = adapter

        closeButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}