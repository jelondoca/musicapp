package com.jelondoca.musicapp.models

data class UserModel(
    val name: String,
    val username: String,
    val email: String,
    val password: String,
    val _id: String? = null
)

