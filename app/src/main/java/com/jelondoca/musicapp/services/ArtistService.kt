package com.jelondoca.musicapp.services

import com.jelondoca.musicapp.models.ArtistModel
import retrofit2.Call
import retrofit2.http.GET

interface ArtistService {
    @GET("artists")
    fun getArtists(): Call<List<ArtistModel>>

}