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
import com.doct24.doct24_android.databinding.FragmentMeetingsBinding
import com.doct24.doct24_android.model.Meeting

class MeetingsFragment : Fragment() {

    private var _binding: FragmentMeetingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val meetingsViewModel: MeetingsViewModel by viewModels()
    private val meetingAdapter: MeetingListAdapter = MeetingListAdapter()

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
        binding.recyclerMeetingList.adapter = meetingAdapter
        binding.meetingTabLayout
        meetingsViewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        meetingsViewModel.getMeetingListFromLocalStorage()
    }

    private fun renderData(data: List<Meeting>) {
        meetingAdapter.setData(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}