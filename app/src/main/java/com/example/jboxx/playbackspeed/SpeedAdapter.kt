package com.example.jboxx.playbackspeed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.jboxx.R

class SpeedAdapter(
    private val context: Context,
    private val speeds: List<String>,
    private val selectedSpeed: String
) : BaseAdapter() {

    override fun getCount(): Int = speeds.size

    override fun getItem(position: Int): Any = speeds[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_speed, parent, false)

        val speedText = view.findViewById<TextView>(R.id.speedText)
        val checkIcon = view.findViewById<ImageView>(R.id.checkIcon)

        val speed = speeds[position]
        speedText.text = speed

        checkIcon.visibility = if (speed == selectedSpeed) View.VISIBLE else View.GONE

        return view
    }
}