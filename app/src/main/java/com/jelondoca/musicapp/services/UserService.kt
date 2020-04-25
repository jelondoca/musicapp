package com.jelondoca.musicapp.services

import com.jelondoca.musicapp.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("users")
    fun createUser(@Body user: UserModel): Call<UserModel>
}