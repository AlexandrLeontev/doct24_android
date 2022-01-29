package com.doct24.doct24_android.view.meeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentMeetingsBinding
import com.doct24.doct24_android.model.Meeting
import com.doct24.doct24_android.view.doctor.DoctorProfileFragment
import com.google.android.material.tabs.TabLayout

class MeetingsFragment : Fragment(), MeetingListAdapter.MeetingsAdapterClickListener{

    private var _binding: FragmentMeetingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val meetingsViewModel: MeetingsViewModel by viewModels()
    private val meetingAdapter: MeetingListAdapter = MeetingListAdapter()
    private var isFuture: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingsBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.meetingsBackButton.setOnClickListener { findNavController().popBackStack() }
        binding.recyclerMeetingList.adapter = meetingAdapter
        meetingAdapter.setAdapterOnClickListener(this)
        binding.meetingTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    FUTURE -> {
                        isFuture = true
                        meetingsViewModel.getFutureMeetingList()
                    }

                    PAST -> {
                        isFuture = false
                        meetingsViewModel.getPastMeetingList()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        meetingsViewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        meetingsViewModel.getFutureMeetingList()
    }

    private fun renderData(data: List<Meeting>) {
        meetingAdapter.setData(data, isFuture)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val FUTURE = 0
        private const val PAST = 1
    }

    override fun onButtonChangeClick(meeting: Meeting) {
    }

    override fun onDoctorClick(meeting: Meeting) {
        findNavController().navigate(
            R.id.action_meetingsFragment_to_doctorProfileFragment,
            Bundle().apply
            { putParcelable(DoctorProfileFragment.BUNDLE_DOCTOR, meeting.doctor) })
    }

    override fun onPayClick() {
    }

    override fun onStartClick() {
    }
}