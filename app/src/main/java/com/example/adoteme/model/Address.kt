package com.example.adoteme.model

import com.google.gson.annotations.SerializedName

data class Address (
        @SerializedName("country") val country: String,
        @SerializedName("state") val state: String,
        @SerializedName("city") val city: String,
        @SerializedName("neighborhood") val neighborhood: String,
        @SerializedName("street") val street: String,
        @SerializedName("number") val number: Int
) {
        @SerializedName("id") val id: Long = 0
}

