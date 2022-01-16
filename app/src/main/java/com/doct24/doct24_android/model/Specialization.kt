package com.doct24.doct24_android.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Specialization(
    val id: Int,
    val title: String
): Parcelable
