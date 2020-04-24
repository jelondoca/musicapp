package com.jelondoca.musicapp.listeners

import com.jelondoca.musicapp.models.SongModel

interface SongListener {

    fun onClickedSong(
        song: SongModel
    )
}