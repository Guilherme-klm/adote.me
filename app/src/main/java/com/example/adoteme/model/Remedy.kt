package com.example.adoteme.model

import com.google.gson.annotations.SerializedName

data class Remedy(
        @SerializedName("name") val name: String,
        @SerializedName("date") val date: String,
        @SerializedName("validity") val validity: String,
)
