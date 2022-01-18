package com.doct24.doct24_android.view.doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.databinding.FragmentVpDoctorProfileAboutBinding
import com.doct24.doct24_android.model.Doctor

class DoctorProfileVPAboutFragment : Fragment() {
    companion object {
        const val BUNDLE_DOCTOR = "doctor"
    }

    private var _binding: FragmentVpDoctorProfileAboutBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var doctor: Doctor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVpDoctorProfileAboutBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doctor = arguments?.getParcelable(BUNDLE_DOCTOR) ?:Doctor(0, "", "", "", "", 0, "", "", "",
            "", "", "", "", "","", null, null)
        init()
    }

    private fun init() {
        with(binding){
            doctorProfileSeniorityInput.text = doctor.age_category //TODO не вижу стажа в модели
            doctorProfileEducationInput.text = doctor.education
            doctorProfileExperienceInput.text = doctor.specialization //TODO не вижу опыта работы в модели
            doctorProfileHealingInput.text = doctor.specialization //TODO и "лечение заболеваний" тоже
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}