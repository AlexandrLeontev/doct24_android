package com.doct24.doct24_android.view.doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.databinding.FragmentDoctorsListBinding
import com.doct24.doct24_android.model.Specialization

class DoctorListFragment : Fragment () {

    companion object {
        const val SPEC_BUNDLE = "spec"
    }

    private var _binding: FragmentDoctorsListBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var specialization: Specialization
    private val adapter = DoctorListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorsListBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        specialization = arguments?.getParcelable(SPEC_BUNDLE) ?: Specialization(0, "")
        with(binding){
            doctorListTitle.text = specialization.title
            recyclerDoctorsList.adapter = adapter
            adapter.setData(specialization)
            adapter.setOnItemViewClickListener {
                //TODO to doctor profile
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}