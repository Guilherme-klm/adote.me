package com.example.adoteme.repository

import com.example.adoteme.model.Login
import com.example.adoteme.model.UserLogged
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginEndPoints {

    @POST("/login")
    suspend fun login (@Body login: Login): Response<UserLogged>
}