package com.doct24.doct24_android.view.patient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentProfileBinding

//@Suppress("UNREACHABLE_CODE")
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val adapter = PatientAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)



        binding.patientMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.data -> {
                    Toast.makeText(requireContext(), "000", Toast.LENGTH_SHORT).show()
//                    adapter.submitList()
                }
                R.id.documents -> {
                    Toast.makeText(requireContext(), "111", Toast.LENGTH_SHORT).show()

                }
                R.id.settings -> {
                    Toast.makeText(requireContext(), "222", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        return binding.root
    }

}