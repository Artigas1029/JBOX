package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jboxx.data.Movies
import com.example.jboxx.history.MoviesCustomListViewAdapter

class HistoryActivity : Activity() {

    private lateinit var adapter: MoviesCustomListViewAdapter
    private lateinit var adapter1: MoviesCustomListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val backButton = findViewById<ImageView>(R.id.back)
        backButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        val listView = findViewById<ListView>(R.id.listview)


        val movieList = mutableListOf(
            Movies("One Piece","Episode 1124" ,R.drawable.one_piece_poster),
            Movies("Solo Leveling","Episode 12" , R.drawable.anime)
        )

        adapter = MoviesCustomListViewAdapter(this, movieList,
            onClick = { movies ->
                Toast.makeText(this, "${movies.movieTitle} was clicked", Toast.LENGTH_LONG).show()
            },
            onLongClick = { movies ->
                Toast.makeText(this, "${movies.movieTitle} was long clicked", Toast.LENGTH_LONG).show()
            },
            onDeleteClick = { movies ->
                movieList.remove(movies)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "${movies.movieTitle} deleted", Toast.LENGTH_SHORT).show()
            }
        )

        val listView1 = findViewById<ListView>(R.id.listview1)

        val movieList1 = mutableListOf(
            Movies("Venom: The Last Dance","" ,R.drawable.venom_poster),
            Movies("Spider-Man: No way home","" ,R.drawable.spiderman_poster),
            Movies("Avengers: Endgame","" ,R.drawable.avengers_poster)
        )

        adapter1 = MoviesCustomListViewAdapter(this, movieList1,
            onClick = { movies1 ->
                Toast.makeText(this, "${movies1.movieTitle} was clicked", Toast.LENGTH_LONG).show()
            },
            onLongClick = { movies1 ->
                Toast.makeText(this, "${movies1.movieTitle} was long clicked", Toast.LENGTH_LONG).show()
            },
            onDeleteClick = { movies1 ->
                movieList1.remove(movies1)
                adapter1.notifyDataSetChanged()
                Toast.makeText(this, "${movies1.movieTitle} deleted", Toast.LENGTH_SHORT).show()
            }
        )

        listView.adapter = adapter
        listView1.adapter = adapter1
    }
}