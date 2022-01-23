package com.doct24.doct24_android.model.remoterepo

import com.doct24.doct24_android.ApiService
import com.doct24.doct24_android.model.PatientsDTO
import com.google.gson.GsonBuilder
import com.squareup.picasso.BuildConfig
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemotePatientDataSource {
    private val patientDataSourceApi = Retrofit.Builder()
        .baseUrl("https://doct24.com/api/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        )
        .build().create(ApiService::class.java)

    fun getPatientDetails(lat: Double, lon: Double, callback: Callback<PatientsDTO>) {
//        patientDataSourceApi.getPatients(BuildConfig.APPLICATION_ID.).enqueue(callback)
    }

}