package com.example.adoteme.repository

import com.example.adoteme.model.Login
import com.example.adoteme.model.UserLogged
import com.example.adoteme.utils.RetrofitClient
import retrofit2.Response

class LoginRepository {

    private val retrofit = RetrofitClient.buildService(LoginEndPoints::class.java)

    suspend fun save(login: Login): Response<UserLogged> {
      return retrofit.login(login)
    }
}