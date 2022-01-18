package com.doct24.doct24_android.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Doctor(
    val id: Int,
    val username: String,
    val first_name: String,
    val last_name: String,
    val avatar: String?,
    val age: Int,
    val specialization: String,
    val country: String,
    val city: String,
    val phone_number: String,
    val email: String,
    val category: String, //это вообще что именно?х)
    val age_category: String,
    val education: String,
    val degree: String,
    val appointment_for_doctors: @RawValue List<String>?,
    val comment_for_doctor: @RawValue List<String>?
) : Parcelable
