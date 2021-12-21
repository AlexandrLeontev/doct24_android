package com.doct24.doct24_android.view.patient.dataFragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.databinding.FragmentPatientDataBinding


class PatientDataFragment : Fragment() {

//    private lateinit var viewModel: PatientDataViewModel
    private var _binding: FragmentPatientDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPatientDataBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.patientDataBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(PatientDataViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}