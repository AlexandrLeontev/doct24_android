package com.doct24.doct24_android.view.patient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.MainActivity
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentProfileBinding

class PatientProfileFragment: Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)


        (requireActivity() as? MainActivity)?.setImg(R.drawable.patient_profile_bkg)

        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
           (requireActivity() as? MainActivity)?.delImg()

    }

}