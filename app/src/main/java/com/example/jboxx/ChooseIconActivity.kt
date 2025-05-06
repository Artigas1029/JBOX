package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChooseIconActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_icon)

        val iconMap = mapOf(
            R.id.marvels_icon1 to R.drawable.image_1,
            R.id.marvels_icon2 to R.drawable.image_2,
            R.id.marvels_icon3 to R.drawable.image_3,
            R.id.marvels_icon4 to R.drawable.image_4,
            R.id.disney_icon1 to R.drawable.image_4,
            R.id.disney_icon2 to R.drawable.image_5,
            R.id.disney_icon3 to R.drawable.image_6,
            R.id.disney_icon4 to R.drawable.image_7,
            R.id.trends_icon1 to R.drawable.image_8,
            R.id.trends_icon2 to R.drawable.image_9,
            R.id.trends_icon3 to R.drawable.image_10,
            R.id.trends_icon4 to R.drawable.image_11,
            R.id.animes_icon1 to R.drawable.image_12,
            R.id.animes_icon2 to R.drawable.image_13,
            R.id.animes_icon3 to R.drawable.image_14,
            R.id.animes_icon4 to R.drawable.image_15,
            R.id.animes_icon5 to R.drawable.image_16
        )

        iconMap.forEach { (viewId, drawableId) ->
            findViewById<ImageView>(viewId).setOnClickListener {
                startActivity(Intent(this, EditProfileActivity::class.java).apply {
                    putExtra("SELECTED_ICON", drawableId)
                })
                finish()
            }
        }
    }
}
