package com.example.adoteme.model

import com.google.gson.annotations.SerializedName

data class Animal(
        @SerializedName("name") val name: String,
        @SerializedName("breed") val breed: String,
        @SerializedName("vaccineOutputDTO") val vaccine: Vaccine,
        @SerializedName("remedyOutputDTO") val remedy: Remedy,
        @SerializedName("diseaseOutputDTO") val disease: Disease
)
