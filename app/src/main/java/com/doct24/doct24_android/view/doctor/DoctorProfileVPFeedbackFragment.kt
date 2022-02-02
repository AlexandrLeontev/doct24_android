package com.doct24.doct24_android.view.doctor

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.databinding.FragmentVpDoctorProfileFeedbackBinding
import com.doct24.doct24_android.model.Doctor

class DoctorProfileVPFeedbackFragment : Fragment() {

//    companion object {
//        const val BUNDLE_DOCTOR = "doctor"
//    }
//
//    private var _binding: FragmentVpDoctorProfileFeedbackBinding? = null
//    private val binding get() = _binding!!
//    private lateinit var navController: NavController
//    private lateinit var doctor: Doctor
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentVpDoctorProfileFeedbackBinding.inflate(inflater, container, false)
//        navController = NavHostFragment.findNavController(this)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        doctor = arguments?.getParcelable(BUNDLE_DOCTOR) ?: Doctor(0, "", "", "", "", 0, "", "", "",
//            "", "", "", "", "", "", null, null)
//        init()
//    }
//
//    private fun init() {
//        with(binding) {
//            doctorProfileRatingBar.rating = 4.75f
//            doctorProfileRatingText.text = doctorProfileRatingBar.rating.toString()
//            progressProfessionality.max = 100
//
//            val currentProgress = 60
//            ObjectAnimator.ofInt(progressProfessionality,"progress",currentProgress)
//                .duration = 1000
//
//        }
//    }
//
//
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}