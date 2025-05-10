package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class TicketBookingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_booking)

        val cancelButton = findViewById<Button>(R.id.cancel_button)

        cancelButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        val titleText = findViewById<TextView>(R.id.movieTitleText)
        val movieTitle = intent.getStringExtra("movie_title")
        if (movieTitle != null) {
            titleText.text = movieTitle
        }


        val movies = listOf(
            "Avengers: Endgame", "Spider-man: No Way Home", "Venom", "The Goblin",
            "Solo Leveling", "One Piece: Egghead Arc", "Loki", "Lucifer",
            "Money Heist", "Peaky Blinders", "When Life Gives You Tangers", "My Demon",
            "It's Okay Not To Be Okay", "Hotel De Luna", "John Wick", "John Wick: Ballerina",
            "The Greatest Showman", "Avatar: The Water of Water", "Frieren",
            "Violet Evergarden", "Josee, the Tiger and the Fish", "Your Lie in April"
        )

        val autoComplete: AutoCompleteTextView = findViewById(R.id.dropdown_cinema)

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, movies)

        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }
}
