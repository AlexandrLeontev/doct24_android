package com.doct24.doct24_android.model.localrepo

import com.doct24.doct24_android.model.Doctor
import com.doct24.doct24_android.model.IMeetingRepository
import com.doct24.doct24_android.model.Meeting

class LocalMeetingRepository : IMeetingRepository {

    private fun getDefaultMeetingList(): MutableList<Meeting> {
        val meetingList: MutableList<Meeting> = mutableListOf()
        for (i in 1..20) {
            meetingList.add(
                Meeting(
                    i,
                    "patient$i",
                    Doctor(
                        i,
                        "doctor_nick$i",
                        "Иван",
                        "Иванов",
                        "https://img.joinfo.com/i/2021/06/800x0/60d5d0d02683d.jpg",
                        25 + i,
                        "Акушер",
                        "Россия",
                        "Москва",
                        "+7999999991$i",
                        "doctor_email$i@mail.ru",
                        "NO",
                        "ADL",
                        "University of Oxford",
                        "Кандидат наук",
                        null,
                        null
                    ),
                    "$i.02.22",
                    "$i:00",
                    "description",
                    i in 5..11
                )
            )
        }
        meetingList.add(
            Meeting(
                100,
                "patient100",
                Doctor(
                    100,
                    "doctor_nick100",
                    "Иван",
                    "Иванов",
                    "https://img.joinfo.com/i/2021/06/800x0/60d5d0d02683d.jpg",
                    25,
                    "Акушер",
                    "Россия",
                    "Москва",
                    "+79999999910",
                    "doctor_email0@mail.ru",
                    "NO",
                    "ADL",
                    "University of Oxford",
                    "Кандидат наук",
                    null,
                    null
                ),
                "24.01.22",
                "10:00",
                "description",
                true
            )
        )
        return meetingList
    }

    override fun getMeetingList(): List<Meeting> = getDefaultMeetingList()
}