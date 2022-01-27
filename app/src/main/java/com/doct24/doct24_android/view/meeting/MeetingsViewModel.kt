package com.doct24.doct24_android.view.meeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doct24.doct24_android.model.IMeetingRepository
import com.doct24.doct24_android.model.Meeting
import com.doct24.doct24_android.model.localrepo.LocalMeetingRepository

class MeetingsViewModel(
    private val meetingRepository: IMeetingRepository = LocalMeetingRepository()

) : ViewModel() {

    private val _meetingLiveData: MutableLiveData<List<Meeting>> = MutableLiveData<List<Meeting>>()
    private val meetingLiveData: LiveData<List<Meeting>> = _meetingLiveData

    fun getLiveData() = meetingLiveData
    fun getMeetingListFromLocalStorage() =
        _meetingLiveData.postValue(meetingRepository.getMeetingList())

}