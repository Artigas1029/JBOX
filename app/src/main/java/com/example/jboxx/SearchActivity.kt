package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView

class SearchActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val TvShowLoki = findViewById<ImageView>(R.id.TvShows_Loki)
        val TvShowLucifer = findViewById<ImageView>(R.id.TvShows_Lucifer)
        val TvShowMoneyHeist = findViewById<ImageView>(R.id.TvShows_MoneyHeist)
        val TvShowPeakyBlinders = findViewById<ImageView>(R.id.TvShows_PeakBlinders)
        TvShowLoki.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "loki_trailer")
            intent.putExtra("synopsis", "After stealing the Tesseract during the events of Avengers: Endgame, Loki finds himself entangled with the Time Variance Authority, a bureaucratic organization that monitors the multiverse. As he navigates alternate timelines, Loki confronts his identity, destiny, and the consequences of his choices.")
            intent.putExtra("movie_title", "Loki")
            startActivity(intent)
        }

        TvShowLucifer.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "lucifer")
            intent.putExtra("synopsis", "Tired of ruling Hell, Lucifer Morningstar abandons his throne and retires to Los Angeles, where he opens a nightclub and begins consulting with the LAPD. As he explores humanity, justice, and redemption, his past from Hell begins to catch up with him.")
            intent.putExtra("movie_title", "Lucifer")
            startActivity(intent)
        }

        TvShowMoneyHeist.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "money_heist")
            intent.putExtra("synopsis", "A criminal mastermind known as \"The Professor\" recruits eight skilled criminals to carry out the biggest heist in recorded history: to print billions of euros in the Royal Mint of Spain. With hostages, law enforcement, and emotions in the mix, the team must stay united under pressure.")
            intent.putExtra("movie_title", "Loki")
            startActivity(intent)
        }

        TvShowPeakyBlinders.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "peaky_blinders")
            intent.putExtra("synopsis", "Set in post-WWI Birmingham, England, Peaky Blinders follows the rise of Tommy Shelby and his gang as they carve out a criminal empire. Battling rival gangs, corruption, and the law, Tommy’s ambition grows, along with the cost of power.")
            intent.putExtra("movie_title", "Lucifer")
            startActivity(intent)
        }

        val koreanTvShowsTangerine = findViewById<ImageView>(R.id.KoreanTvShows_Tangerine)
        val koreanTvShowsMyDemon = findViewById<ImageView>(R.id.KoreanTvShows_MyDemon)
        val koreanTvShowsItsOkay= findViewById<ImageView>(R.id.KoreanTvShows_ItsOkay)
        val koreanTvShowsHotel = findViewById<ImageView>(R.id.KoreanTvShows_Hotel)
        koreanTvShowsTangerine.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "when_life_gives_you_tangerines")
            intent.putExtra("synopsis", "A heartwarming tale of a young woman who returns to her rural hometown to reconnect with her roots and rebuild her life after a series of failures in the city. There, she rediscovers love, family, and the simple joys of life.")
            intent.putExtra("movie_title", "When Life Gives You Tangerines")
            startActivity(intent)
        }

        koreanTvShowsMyDemon.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "demon")
            intent.putExtra("synopsis", "A mysterious demon who once thrived on chaos loses his powers and must live among humans. To regain what he lost, he forms an unlikely bond with a lonely woman—one that could either destroy them or set them free.")
            intent.putExtra("movie_title", "My Demon")
            startActivity(intent)
        }

        koreanTvShowsItsOkay.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "its_okay_not_to_be_okay")
            intent.putExtra("synopsis", "A psychiatric hospital caregiver with emotional scars meets a famous children’s book author who has antisocial personality disorder. As their relationship grows, they embark on a journey of healing and self-discovery.")
            intent.putExtra("movie_title", "It's Okay Not To Be Okay")
            startActivity(intent)
        }

        koreanTvShowsHotel.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "hotel_de_luna")
            intent.putExtra("synopsis", "In the heart of Seoul lies Hotel Del Luna, a mysterious hotel for ghosts with unresolved grudges. When a young hotel manager takes over, he uncovers secrets about its beautiful but cursed owner and the tragic story that binds them.")
            intent.putExtra("movie_title", "Hotel De Luna")
            startActivity(intent)
        }

        val moviesJohnWick = findViewById<ImageView>(R.id.Movies_JohnWick)
        val movesJohnWickBallerina = findViewById<ImageView>(R.id.Movies_JohnWickBallerina)
        val moviesGreatestShowman= findViewById<ImageView>(R.id.Movies_TheGreatestShowman)
        val moviesAvatar = findViewById<ImageView>(R.id.Movies_Avatar)
        moviesJohnWick.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "john_wick")
            intent.putExtra("synopsis", "After losing his wife, legendary assassin John Wick comes out of retirement to seek revenge on the men who stole his car and killed his dog—the last gift from his wife. His vengeance unleashes chaos in the criminal underworld.")
            intent.putExtra("movie_title", "John Wick")
            startActivity(intent)
        }

        movesJohnWickBallerina.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "johnwick_ballerina")
            intent.putExtra("synopsis", "A young assassin trained in the same secret organization as John Wick embarks on a mission of revenge to hunt down those who murdered her family, navigating betrayal, danger, and a legacy of violence.")
            intent.putExtra("movie_title", "Johnwick: Ballerina")
            startActivity(intent)
        }

        moviesGreatestShowman.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "The_greatest_showman")
            intent.putExtra("synopsis", "Inspired by the life of P.T. Barnum, this musical celebrates the birth of show business. With a cast of outcasts and dreamers, Barnum builds a circus empire that dazzles the world and changes entertainment forever.")
            intent.putExtra("movie_title", "The Greatest Showman")
            startActivity(intent)
        }

        moviesAvatar.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "avatar")
            intent.putExtra("synopsis", "Years after the events of Avatar, Jake Sully and Neytiri now lead their family on Pandora. When new threats arise from the oceans and beyond, they must fight to protect their home and people from human invaders once again.")
            intent.putExtra("movie_title", "Avatar: The Way of the Water")
            startActivity(intent)
        }

        val animeFrieren = findViewById<ImageView>(R.id.Animes1)
        val animeVioletEvergarden = findViewById<ImageView>(R.id.Animes2)
        val animeJoseeTheTigerTheFish= findViewById<ImageView>(R.id.Animes3)
        val animeYourLieInApril = findViewById<ImageView>(R.id.Animes4)
        animeFrieren.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "frieren")
            intent.putExtra("synopsis", "After the hero’s party defeats the Demon King, elven mage Frieren outlives her comrades and begins a new journey to understand humanity, emotions, and the meaning of the friendships she once took for granted.")
            intent.putExtra("movie_title", "Frieren")
            startActivity(intent)
        }

        animeVioletEvergarden.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "violet_evergarden")
            intent.putExtra("synopsis", "A former soldier, Violet Evergarden becomes a ghostwriter to understand human emotions and the meaning of “I love you” the last words her commander said to her. Through writing, she heals the hearts of others and herself.")
            intent.putExtra("movie_title", "Violet Evergarden")
            startActivity(intent)
        }

        animeJoseeTheTigerTheFish.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "josee")
            intent.putExtra("synopsis", "A college student meets a disabled girl named Josee, who rarely leaves her home. As they grow closer, both learn to pursue their dreams and face the challenges of life and love with courage.")
            intent.putExtra("movie_title", "Josee, the Tiger and the Fish")
            startActivity(intent)
        }

        animeYourLieInApril.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("movie_name", "your_lie_in_april")
            intent.putExtra("synopsis", "After the death of his mother, piano prodigy Kousei Arima loses his ability to hear music. His world is changed forever when he meets a free-spirited violinist who helps him rediscover his passion, though she harbors a secret that will break his heart.")
            intent.putExtra("movie_title", "Your Lie in April")
            startActivity(intent)
        }
    }
}
