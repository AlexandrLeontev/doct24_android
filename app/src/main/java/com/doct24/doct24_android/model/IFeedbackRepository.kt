package com.doct24.doct24_android.model

interface IFeedbackRepository {
    fun getFeedbacks(doctorID: Int): List<Feedback>
}