package com.doct24.doct24_android.model

data class Feedback(
    val id: Int,
    val doctorID: Int,
    val author: String,
    val created_at: String,
    val text: String,
    val updated_at: String?,
    val rating: Int
)
