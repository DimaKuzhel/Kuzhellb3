package com.app.kuzhelretrofit.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.kuzhelretrofit.R

import com.app.kuzhelretrofit.data.model.RootProject
import com.bumptech.glide.Glide

class CustomAdapter(
    val context: Context,
    private val dataSet: RootProject
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.NameTv)
        val textViewGenre: TextView = view.findViewById(R.id.GenreTv)
        val image: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_one_layout, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewName.text=dataSet.Search[position].Title
        viewHolder.textViewGenre.text=dataSet.Search[position].Year
        Glide.with(context)
            .load(dataSet.Search[position].Poster.toString())
            .circleCrop()
            .into(viewHolder.image)
    }

    override fun getItemCount() = dataSet.Search.size
}