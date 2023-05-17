package com.example.StreamItMovieApp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.StreamItMovieApp.R

class AdapterRV(private var myList2 : List<DataCall>) : RecyclerView.Adapter<AdapterRV.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = myList2.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = myList2[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.tvMovie.text = currentItem.movieName
        holder.tvYear.text = currentItem.movieYear

        val layoutParams = holder.itemView.layoutParams as RecyclerView.LayoutParams
        layoutParams.setMargins(0, 0, 0, 0)
        holder.itemView.layoutParams = layoutParams
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView = itemView.findViewById(R.id.imvItem)
        var tvMovie : TextView = itemView.findViewById(R.id.tvMovie)
        var tvYear : TextView = itemView.findViewById(R.id.tvYear)

    }

}


