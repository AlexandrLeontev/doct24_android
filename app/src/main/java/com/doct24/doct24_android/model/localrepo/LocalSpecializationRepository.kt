package com.doct24.doct24_android.model.localrepo

import com.doct24.doct24_android.model.Specialization

class LocalSpecializationRepository {

    private val specializationList = listOf(
        Specialization(1, "Акушер"),
        Specialization(2, "Аллерголог"),
        Specialization(3, "Ангиохирург"),
        Specialization(4, "Андролог"),
        Specialization(5, "Анестезиолог"),
        Specialization(6, "Аудиолог"),
        Specialization(7, "Венеролог"),
        Specialization(8, "Вертебролог"),
        Specialization(9, "Врач лабораторной диагностики"),
        Specialization(10, "Врач лечебной физкультуры"),
        Specialization(11, "Врач магнитно-резонансной томографии"),
        Specialization(12, "Врач общей практики"),
        Specialization(13, "Врач спортивной медицины")
    )

    fun getSpecialization() = specializationList

}