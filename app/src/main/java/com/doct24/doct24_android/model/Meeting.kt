package com.doct24.doct24_android.model

data class Meeting(
 val id: Int,
 val patient: String,
 val doctor: Doctor,
 val date: String,
 val time: String,
 val description: String?,
 val accepted: Boolean
)