package com.example.jboxx.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.jboxx.R
import com.example.jboxx.data.Movies

class MoviesCustomListViewAdapter(
    private val context: Context,
    private val movieList: MutableList<Movies>,
    private val onClick: (Movies) -> Unit,
    private val onLongClick: (Movies) -> Unit,
    private val onDeleteClick: (Movies) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = movieList.size
    override fun getItem(position: Int): Any = movieList[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.history_items_listview,
                parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val movie = movieList[position]
        holder.movieTitle.text = movie.movieTitle
        holder.episode.text = movie.episode
        holder.moviePoster.setImageResource(movie.photoRes)

        view.setOnClickListener {
            onClick(movie)
        }
        view.setOnLongClickListener {
            onLongClick(movie)
            true
        }
        val deleteIcon = view.findViewById<ImageView>(R.id.delete)
        deleteIcon.setOnClickListener {
            onDeleteClick(movie)
        }

        return view
    }
    private class ViewHolder(view: View) {
        val movieTitle: TextView = view.findViewById(R.id.tvMovieTitle)
        val episode: TextView = view.findViewById(R.id.tvEpisode)
        val moviePoster: ImageView = view.findViewById(R.id.moviePoster)
    }
}
