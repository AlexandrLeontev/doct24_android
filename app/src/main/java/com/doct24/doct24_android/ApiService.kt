package com.doct24.doct24_android

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

interface ApiService {


    @GET("/patients")
    fun getPatients(): ApiPatientDetailsModel
}


data class ApiPatientDetailsModel(
        val id: Int?,
        @SerializedName("username") val username: String,
)