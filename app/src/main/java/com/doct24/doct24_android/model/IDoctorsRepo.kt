package com.doct24.doct24_android.model

interface IDoctorsRepo {
    fun getDoctorsList(category: Specialization): List<Doctor>
}