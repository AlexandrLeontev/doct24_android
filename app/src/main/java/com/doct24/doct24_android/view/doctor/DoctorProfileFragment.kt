package com.doct24.doct24_android.view.doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.databinding.FragmentDoctorProfileBinding
import com.doct24.doct24_android.databinding.FragmentDoctorsListBinding
import com.doct24.doct24_android.model.Doctor

class DoctorProfileFragment : Fragment() {

    companion object {
        const val BUNDLE_DOCTOR = "doctor"
    }

    private var _binding: FragmentDoctorProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var doctor: Doctor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorProfileBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doctor = arguments?.getParcelable(BUNDLE_DOCTOR) ?:Doctor(0, "", "", "", "", 0, "", "", "",
        "", "", "", "", "", null, null)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}