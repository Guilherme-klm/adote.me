package com.example.adoteme.model

import com.google.gson.annotations.SerializedName

data class Account(
        @SerializedName("name") val name: String,
        @SerializedName("birthDate") val birthDate: String,
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String,
        @SerializedName("address") val address: Address
) {
        @SerializedName("id") val id: Long = 0
}
