package com.example.adoteme.service

import com.example.adoteme.dtl.PublicationOutputDTO
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject

class PublicationConverter(private val publicationOutputDTO: PublicationOutputDTO)  {

    fun createJsonPublication(): JsonObject {
        val publicationUserObject = JsonObject()
        publicationUserObject.addProperty("id", publicationOutputDTO.publicationUser.id)
        publicationUserObject.addProperty("name", publicationOutputDTO.publicationUser.name)

        val vaccineObject = JsonObject()
        vaccineObject.addProperty("name", publicationOutputDTO.animal.vaccineOutputDTO.name)
        vaccineObject.addProperty("date", publicationOutputDTO.animal.vaccineOutputDTO.date)
        vaccineObject.addProperty("validity", publicationOutputDTO.animal.vaccineOutputDTO.validity)

        val remedyObject = JsonObject()
        remedyObject.addProperty("name", publicationOutputDTO.animal.remedyOutputDTO.name)
        remedyObject.addProperty("date", publicationOutputDTO.animal.remedyOutputDTO.date)
        remedyObject.addProperty("validity", publicationOutputDTO.animal.remedyOutputDTO.validity)

        val diseaseObject = JsonObject()
        diseaseObject.addProperty("name", publicationOutputDTO.animal.disease.name)

        val animalObject = JsonObject()
        animalObject.addProperty("name", publicationOutputDTO.animal.name)
        animalObject.addProperty("breed", publicationOutputDTO.animal.breed)
        animalObject.add("vaccine", vaccineObject)
        animalObject.add("remedy", remedyObject)
        animalObject.add("disease", diseaseObject)

        val publicationObject = JsonObject()
        publicationObject.addProperty("description", publicationOutputDTO.description)
        publicationObject.addProperty("state", publicationOutputDTO.state)
        publicationObject.addProperty("city", publicationOutputDTO.city)
        publicationObject.addProperty("neighborhood", publicationOutputDTO.neighborhood)
        publicationObject.add("user", publicationUserObject)
        publicationObject.add("animal", animalObject)

        return publicationObject
    }

    private fun convertJsonToGson(publicationJsonObject: JSONObject): PublicationOutputDTO {
        return Gson().fromJson(publicationJsonObject.toString(), PublicationOutputDTO::class.java)
    }
}