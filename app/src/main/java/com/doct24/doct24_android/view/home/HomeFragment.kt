package com.doct24.doct24_android.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentHomeBinding
import com.doct24.doct24_android.view.MyOutlineProvider
import com.doct24.doct24_android.view.doctor.DoctorProfileFragment

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val adapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setOnItemViewClickListener { doctor ->
            findNavController().navigate(R.id.action_homeFragment_to_doctorProfileFragment, Bundle().apply {
                putParcelable(DoctorProfileFragment.BUNDLE_DOCTOR, doctor)
            })
        }
        binding.mainRecycler.adapter = adapter
        adapter.setLocalData()

        with(binding){
            buttonConnect.setOnClickListener {
                showPopUpNotify()
            }
            buttonHealthCheck.setOnClickListener {
                showPopUpNotify()
            }
            buttonHeartbeat.setOnClickListener {
                showPopUpNotify()
            }
            buttonMedCard.setOnClickListener {
                showPopUpNotify()
            }
        }
    }

    fun showPopUpNotify(){
        with(binding){
            popUpFutureRelease.visibility = View.VISIBLE
            materialButton.setOnClickListener {
                popUpFutureRelease.visibility = View.GONE
            }
        }

    }

}