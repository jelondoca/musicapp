package com.jelondoca.musicapp.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jelondoca.musicapp.listeners.SongListener
import com.jelondoca.musicapp.models.SongModel
import kotlinx.android.synthetic.main.item_song.view.*

class SongHolder(private val view: View):RecyclerView.ViewHolder(view) {

    fun bindSong(song: SongModel, listener: SongListener){
        view.txtTitleSong.text = song.name
        view.txtDurationSong.text = calculateDuration(song.time)
        view.setOnClickListener{
            listener.onClickedSong(song)
        }
    }

    private fun calculateDuration(duration: String):String{
        val minutes = duration.toInt()/1000/60
        val seconds = duration.toInt()/1000 % 60
        return "$minutes:${if(seconds <10) "0$seconds" else seconds}"
    }
}