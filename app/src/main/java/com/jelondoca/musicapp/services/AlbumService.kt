package com.jelondoca.musicapp.services

import com.jelondoca.musicapp.models.AlbumObjectModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("albums")
    fun getAlbums(@Query("artist") value: Int): Call<List<AlbumObjectModel>>
}