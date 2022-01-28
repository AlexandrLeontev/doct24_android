package com.doct24.doct24_android.view.meeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doct24.doct24_android.model.IMeetingRepository
import com.doct24.doct24_android.model.Meeting
import com.doct24.doct24_android.model.localrepo.LocalMeetingRepository
import java.text.SimpleDateFormat
import java.util.*

class MeetingsViewModel(
    private val meetingRepository: IMeetingRepository = LocalMeetingRepository()

) : ViewModel() {

    private val _meetingLiveData: MutableLiveData<List<Meeting>> = MutableLiveData<List<Meeting>>()
    private val meetingLiveData: LiveData<List<Meeting>> = _meetingLiveData

    fun getLiveData() = meetingLiveData
    fun getFutureMeetingList() {
        val futureList: MutableList<Meeting> = mutableListOf()
        meetingRepository.getMeetingList().forEach {
            val validUntil = it.date
            val sdf = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            val strDate: Date? = sdf.parse(validUntil)
            if (strDate != null) {
                if (System.currentTimeMillis() < strDate.time) {
                    futureList.add(it)
                }
            }
        }
        _meetingLiveData.postValue(futureList)
    }

    fun getPastMeetingList() {
        val pastList: MutableList<Meeting> = mutableListOf()
        meetingRepository.getMeetingList().forEach {
            val validUntil = it.date
            val sdf = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            val strDate: Date? = sdf.parse(validUntil)
            if (strDate != null) {
                if (System.currentTimeMillis() > strDate.time) {
                    pastList.add(it)
                }
            }
        }
        _meetingLiveData.postValue(pastList)
    }
}