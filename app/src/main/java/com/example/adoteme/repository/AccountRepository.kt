package com.example.adoteme.repository

import com.example.adoteme.model.Account
import com.example.adoteme.utils.RetrofitClient
import retrofit2.Response

class AccountRepository {

    private val retrofit = RetrofitClient.buildService(AccountEndPoints::class.java)

    suspend fun createAccount(account: Account): Response<String> {
        return retrofit.createUser(account)
    }
}