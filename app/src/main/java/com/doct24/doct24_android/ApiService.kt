package com.doct24.doct24_android

import com.doct24.doct24_android.model.Patients
import com.doct24.doct24_android.model.PatientsDTO
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("/patients")
    fun getPatients(): ApiPatientDetailsModel

}


data class ApiPatientDetailsModel(
    val id: Int?,
    @Header("Patient-API-Key") val token: String,

    @SerializedName("username") val username: String,
): Call<PatientsDTO>