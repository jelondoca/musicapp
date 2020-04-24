package com.jelondoca.musicapp.listeners

import android.os.Bundle
import com.jelondoca.musicapp.models.ArtistModel

interface ArtistListener {

    fun onClickedArtist(
        bundle: Bundle?,
        artist: ArtistModel
    )
}