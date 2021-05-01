package com.example.adoteme.repository

import com.example.adoteme.model.Account
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountEndPoints {

    @POST("/user")
    suspend fun createUser (@Body account: Account): Response<String>
}