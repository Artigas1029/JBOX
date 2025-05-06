package com.example.jboxx.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.jboxx.R
import com.example.jboxx.data.Language

class LanguageCustomListViewAdapter(
    private val context: Context,
    private val languageList: List<Language>,
    private var selectedLangCode: String, // Make it mutable to update
    private val onClick: (Language) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = languageList.size
    override fun getItem(position: Int): Any = languageList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        val greenColor = ContextCompat.getColor(context, R.color.green)
        val defaultColor = ContextCompat.getColor(context, android.R.color.white)

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.language_item_listview,
                parent, false
            )
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val language = languageList[position]
        holder.languageName.text = language.name

        holder.languageName.setTextColor(
            if (language.code == selectedLangCode)
                greenColor
            else
                defaultColor
        )

        view.setOnClickListener {
            onClick(language)
        }

        return view
    }

    fun updateSelectedLang(newLangCode: String) {
        selectedLangCode = newLangCode
        notifyDataSetChanged()
    }

    private class ViewHolder(view: View) {
        val languageName: TextView = view.findViewById(R.id.tvLanguageName)
    }
}
