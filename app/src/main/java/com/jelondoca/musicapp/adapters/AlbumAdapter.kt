package com.jelondoca.musicapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jelondoca.musicapp.R
import com.jelondoca.musicapp.holders.AlbumHolder
import com.jelondoca.musicapp.listeners.AlbumListener
import com.jelondoca.musicapp.models.AlbumModel

class AlbumAdapter(private val data: List<AlbumModel>, private val listener: AlbumListener):RecyclerView.Adapter<AlbumHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        return AlbumHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.bindAlbum(data[position], listener)
    }
}