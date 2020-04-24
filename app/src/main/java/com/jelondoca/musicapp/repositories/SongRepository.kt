package com.jelondoca.musicapp.repositories

import com.jelondoca.musicapp.models.SongModel
import com.jelondoca.musicapp.models.SongObjectModel
import com.jelondoca.musicapp.services.factory.ServiceFactory
import com.jelondoca.musicapp.services.SongService
import retrofit2.Call

class SongRepository {
    private var songService: SongService

    init {
        val serviceFactory =
            ServiceFactory()
        songService = serviceFactory.getInstanceSongService()
    }

    fun getSongs(idAlbum: Int): List<SongModel>{
        try{
            val call: Call<List<SongObjectModel>> = songService.getSongs(idAlbum)
            val response = call.execute()
            if(response.isSuccessful){
                return response.body()!![0].songs
            }else {
                throw Exception(response.errorBody().toString())
            }
        }catch (e: Exception){
            throw e
        }
    }
}