package com.jelondoca.musicapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jelondoca.musicapp.R
import com.jelondoca.musicapp.holders.SongHolder
import com.jelondoca.musicapp.listeners.SongListener
import com.jelondoca.musicapp.models.SongModel

class SongAdapter(private val data: List<SongModel>, private val listener: SongListener) :
    RecyclerView.Adapter<SongHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        return SongHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.bindSong(data[position], listener)
    }
}