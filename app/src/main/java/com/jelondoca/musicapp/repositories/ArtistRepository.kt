package com.jelondoca.musicapp.repositories

import com.jelondoca.musicapp.models.ArtistModel
import com.jelondoca.musicapp.services.ArtistService
import com.jelondoca.musicapp.services.factory.ServiceFactory
import retrofit2.Call

class ArtistRepository {
    private var artistService: ArtistService

    init {
        val serviceFactory =
            ServiceFactory()
        artistService = serviceFactory.getInstanceArtistService()
    }

    fun getArtists(): List<ArtistModel> {
        try {
            val call: Call<List<ArtistModel>> = artistService.getArtists()
            val response = call.execute()
            if(response.isSuccessful){

                return response.body()!!.filter { it.name != null }
            }else{
                throw Exception(response.errorBody().toString())
            }
        }catch (e: Exception){
            throw e
        }
    }
}