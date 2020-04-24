package com.jelondoca.musicapp.repositories

import com.jelondoca.musicapp.models.AlbumModel
import com.jelondoca.musicapp.models.AlbumObjectModel
import com.jelondoca.musicapp.services.AlbumService
import com.jelondoca.musicapp.services.ServiceFactory
import retrofit2.Call

class AlbumRepository {
    private var albumService: AlbumService

    init {
        val serviceFactory = ServiceFactory()
        albumService = serviceFactory.getInstanceAlbumService()
    }

    fun getAlbums(idAlbum: Int): List<AlbumModel> {
        try {
            val call: Call<List<AlbumObjectModel>> = albumService.getAlbums(idAlbum)
            val response = call.execute()
            if(response.isSuccessful){

                return response.body()!![0].albums
            }else{
                throw Exception(response.errorBody().toString())
            }
        }catch (e: Exception){
            throw e
        }
    }
}