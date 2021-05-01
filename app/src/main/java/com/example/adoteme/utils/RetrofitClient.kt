package com.example.adoteme.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

object RetrofitClient {

    private val client = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        OkHttpClient.Builder().callTimeout(Duration.ofMinutes(10L)).build()
    } else {
        OkHttpClient.Builder().build()
    }

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}