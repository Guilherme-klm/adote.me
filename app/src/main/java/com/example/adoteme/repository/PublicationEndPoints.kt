package com.example.adoteme.repository

import com.example.adoteme.dtl.PublicationOutputDTO
import com.example.adoteme.model.Publication
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*

interface PublicationEndPoints{

    @POST("/publication")
    @Multipart
    suspend fun postPublication(@Part("publication") publication: JsonObject, @Part image: MultipartBody.Part): Response<String>

    @GET("/publication/{localization}/{value}")
    @Headers("Content-type: application/json")
    suspend fun getPublicationsByLocalization(@Path("localization") localization: String, @Path("value") value: String): Response<List<Publication>>
}