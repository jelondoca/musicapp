package com.jelondoca.musicapp.listeners

import android.os.Bundle
import com.jelondoca.musicapp.models.AlbumModel

interface AlbumListener {

    fun onClickedAlbum(
        bundle: Bundle?,
        album: AlbumModel
    )
}