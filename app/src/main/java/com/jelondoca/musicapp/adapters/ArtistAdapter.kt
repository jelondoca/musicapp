package com.jelondoca.musicapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jelondoca.musicapp.R
import com.jelondoca.musicapp.holders.ArtistHolder
import com.jelondoca.musicapp.listeners.ArtistListener
import com.jelondoca.musicapp.models.ArtistModel

class ArtistAdapter(private val data: List<ArtistModel>, private val listener: ArtistListener) :
    RecyclerView.Adapter<ArtistHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistHolder {
        return ArtistHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
            , listener
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ArtistHolder, position: Int) {
        holder.bindArtist(data[position])
    }
}