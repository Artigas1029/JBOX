package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class DashboardActivity : Activity() {

    private var useremail:String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val profilebutton = findViewById<ImageView>(R.id.profileicon)
        val homebutton = findViewById<ImageView>(R.id.homeicon)
        val ticketBookingButton = findViewById<ImageView>(R.id.bookingtickets)
        val settingsbutton = findViewById<ImageView>(R.id.settingsicon)
        val searchButton = findViewById<ImageView>(R.id.searchicon)

        intent?.let {
            it.getStringExtra("email")?.let { email ->
                useremail = email
            }
        }

        Toast.makeText(this, "Welcome $useremail", Toast.LENGTH_SHORT).show()
        val avengersImage = findViewById<ImageView>(R.id.avengers)
        val nowayhomeImage = findViewById<ImageView>(R.id.spiderman_nowayhome)
        val venomImage = findViewById<ImageView>(R.id.venom)
        val goblinImage = findViewById<ImageView>(R.id.the_goblin)
        val sololevelingImage = findViewById<ImageView>(R.id.solo_leveling)
        val onepieceImage = findViewById<ImageView>(R.id.onepiece_egghead)

        avengersImage.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "avengers_endgame")
            intent.putExtra("synopsis", "The Avengers: Endgame is the epic conclusion to the Infinity Saga, where Earth's heroes gather for one final battle against Thanos to undo the destruction caused in the previous film, Avengers: Infinity War. With time travel and high-stakes action, the Avengers face personal sacrifices, confrontations, and ultimate heroism to save the universe. It's a powerful emotional and action-packed journey that brings closure to several character arcs while laying the groundwork for future Marvel stories.")
            intent.putExtra("movie_title", "Avengers Endgame")
            startActivity(intent)
        }

        nowayhomeImage.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "spiderman_nowayhome")
            intent.putExtra("synopsis", "Spider-Man: No Way Home sees Peter Parker struggling with the consequences of his secret identity being revealed. In a desperate bid to regain his normal life, Peter seeks the help of Doctor Strange, which inadvertently opens the multiverse, unleashing dangerous threats from alternate dimensions. A high-stakes adventure filled with emotional twists and fan-favorite appearances, this movie explores the complexities of identity, sacrifice, and the consequences of meddling with time..")
            intent.putExtra("movie_title", "Spiderman: No Way Home")
            startActivity(intent)
        }

        venomImage.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "venom")
            intent.putExtra("synopsis", "Venom follows Eddie Brock, a journalist who becomes the host of an alien symbiote that gives him incredible powers. Together, they must face off against a corporation that seeks to harness the symbiote's abilities for their own gain. Packed with action, humor, and thrilling moments, Venom offers a darker, more unconventional take on the superhero genre, focusing on the antihero dynamic between Eddie and Venom.")
            intent.putExtra("movie_title", "Venom")
            startActivity(intent)
        }

        goblinImage.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "goblin")
            intent.putExtra("synopsis", "The Goblin is a captivating Korean drama that follows the life of Kim Shin, a 939-year-old goblin who seeks redemption by finding his bride, who holds the key to ending his immortality. The series blends fantasy, romance, and emotional drama as Kim Shin's life intertwines with that of a young woman who has a unique connection to him. Filled with stunning visuals, heart-wrenching moments, and powerful performances, The Goblin explores themes of love, loss, and destiny..")
            intent.putExtra("movie_title", "Goblin")
            startActivity(intent)
        }

        sololevelingImage.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "solo_leveling")
            intent.putExtra("synopsis", "Solo Leveling follows Jinwoo, an ordinary man who becomes a powerful hunter after a mysterious event changes his life. As he navigates through dangerous dungeons and battles terrifying creatures, Jinwoo's journey to uncover his true potential is filled with epic battles, rich character development, and a world on the brink of destruction. This anime adaptation brings the action-packed web novel to life in.")
            intent.putExtra("movie_title", "Solo Leveling")
            startActivity(intent)
        }

        onepieceImage.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "onepiece_egghead")
            intent.putExtra("synopsis", "One Piece continues the thrilling adventure of Luffy and his crew as they embark on their journey to find the fabled One Piece. The Egghead Arc presents a new island filled with secrets and advanced technology, where the Straw Hat Pirates encounter powerful new foes and uncover dark truths about the world. This arc is a perfect blend of high-octane action, humor, and mystery, continuing the saga of one of anime's most beloved franchises.")
            intent.putExtra("movie_title", "One Piece: Egghead Arc")
            startActivity(intent)
        }
        profilebutton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        homebutton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

        searchButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
            finish()
        }

        settingsbutton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }

        ticketBookingButton.setOnClickListener {
            val intent = Intent(this, TicketBookingActivity::class.java)
            Toast.makeText(this, "Ticket icon clicked", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}