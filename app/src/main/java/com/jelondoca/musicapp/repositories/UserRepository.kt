package com.jelondoca.musicapp.repositories

import com.jelondoca.musicapp.models.UserModel
import com.jelondoca.musicapp.services.UserService
import com.jelondoca.musicapp.services.factory.ServiceFactory
import retrofit2.Call

class UserRepository {
    private var userService: UserService

    init {
        val serviceFactory = ServiceFactory()
        userService = serviceFactory.getInstanceUserService()
    }

    fun createUser(user: UserModel): UserModel {
        try {
            val call: Call<UserModel> = userService.createUser(user)
            val response = call.execute()
            if(response.isSuccessful){
                return response.body()!!
            }else{
                throw Exception(response.errorBody().toString())
            }
        }catch (e: Exception){
            throw e
        }
    }
}