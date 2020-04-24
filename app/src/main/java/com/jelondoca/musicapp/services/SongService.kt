package com.jelondoca.musicapp.services

import com.jelondoca.musicapp.models.SongObjectModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SongService {

    @GET("songs")
    fun getSongs(@Query("album") value: Int): Call<List<SongObjectModel>>
}