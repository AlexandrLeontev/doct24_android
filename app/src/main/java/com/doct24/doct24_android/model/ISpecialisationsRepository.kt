package com.doct24.doct24_android.model

interface ISpecialisationsRepository {

    fun getChildSpecList(): List<Specialization>
    fun getAdultSpecList(): List<Specialization>
    fun getFamilySpecList(): List<Specialization>

}