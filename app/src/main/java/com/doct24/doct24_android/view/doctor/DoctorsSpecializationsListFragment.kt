package com.doct24.doct24_android.view.doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.databinding.FragmentDoctorsSpecialisationsListBinding

class DoctorsSpecializationsListFragment : Fragment() {

    private var _binding: FragmentDoctorsSpecialisationsListBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val adapter = DoctorsSpecializationsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorsSpecialisationsListBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerSpec.adapter = adapter
        adapter.setLocalData()
        adapter.setOnItemViewClickListener {
            //переход к списку докторов по категории
        }
    }

}