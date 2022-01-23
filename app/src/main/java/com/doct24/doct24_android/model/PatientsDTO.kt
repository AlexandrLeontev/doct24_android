package com.doct24.doct24_android.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


data class PatientsDTO(
        val fact: FactDTO?
)

data class FactDTO(

        val id: Int,
        val username: String,
        val patronymic: String,
        val sex: String,
        val avatar: String?,
        val age: Int,
        val phone_number: String,
        val email: String,
        val appointment_for_patients: @RawValue List<String>?,
        val comment: @RawValue List<String>?
)
