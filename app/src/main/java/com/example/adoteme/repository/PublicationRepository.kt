package com.example.adoteme.repository

import com.example.adoteme.dtl.PublicationOutputDTO
import com.example.adoteme.model.Publication
import com.example.adoteme.service.PublicationConverter
import com.example.adoteme.utils.RetrofitClient
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

class PublicationRepository {

    private val retrofit = RetrofitClient.buildService(PublicationEndPoints::class.java)

    suspend fun save(publicationOutputDTO: PublicationOutputDTO, body: MultipartBody.Part): Response<String> {
        var converted = PublicationConverter(publicationOutputDTO).createJsonPublication()
        return retrofit.postPublication(converted, body)
    }

     suspend fun getPublicationsByLocalization(localization: String, value: String): Response<List<Publication>> {
        return retrofit.getPublicationsByLocalization(localization, value)
    }
}
