package com.example.adoteme.model

import com.google.gson.annotations.SerializedName

data class Publication(
        @SerializedName("id") val id: String,
        @SerializedName("description") val description: String,
        @SerializedName("imageLink") val imageLink: String,
        @SerializedName("state") val state: String,
        @SerializedName("city") val city: String,
        @SerializedName("neighborhood") val neighborhood: String,
        @SerializedName("street") val street: String,
        @SerializedName("publicationUserOutputDTO") val publicationUser: User,
        @SerializedName("animalOutputDTO") val animal: Animal
)