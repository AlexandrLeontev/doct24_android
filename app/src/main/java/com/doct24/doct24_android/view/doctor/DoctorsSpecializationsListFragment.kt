package com.doct24.doct24_android.view.doctor

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentDoctorsSpecialisationsListBinding
import com.doct24.doct24_android.model.localrepo.LocalSpecializationRepository
import com.doct24.doct24_android.view.hide
import com.doct24.doct24_android.view.show

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
        with(binding) {
            buttonChildrenDoctor.setOnClickListener {
                onBaseCategoryClicked(0)
            }
            buttonAdultDoctor.setOnClickListener {
                onBaseCategoryClicked(1)
            }
            buttonFamilyDoctor.setOnClickListener {
                onBaseCategoryClicked(2)
            }
            smallButtonChildDoctor.setOnClickListener {
                setSmallButtonsStroke(0)
            }
            smallButtonAdultDoctor.setOnClickListener {
                setSmallButtonsStroke(1)
            }
            smallButtonFamilyDoctor.setOnClickListener {
                setSmallButtonsStroke(2)
            }
        }
        binding.recyclerSpec.adapter = adapter
    }

    private fun onBaseCategoryClicked(categoryID: Int) {
        with(binding) {
            buttonChildrenDoctor.hide()
            buttonAdultDoctor.hide()
            buttonFamilyDoctor.hide()
            smallButtonChildDoctor.show()
            smallButtonAdultDoctor.show()
            smallButtonFamilyDoctor.show()
            setSmallButtonsStroke(categoryID)
        }
    }

    private fun setSmallButtonsStroke(categoryID: Int){
        with(binding){
            when (categoryID) {
                0 -> {
                    smallButtonAdultDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonAdultDoctor.invalidate()
                    smallButtonFamilyDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonFamilyDoctor.invalidate()
                    smallButtonChildDoctor.strokeWidth = 2
                    smallButtonChildDoctor.strokeColor = resources.getColor(R.color.mainGreen)
                    adapter.setData(LocalSpecializationRepository().getChildSpecList())
                    recyclerSpec.show()
                }
                1 -> {
                    smallButtonChildDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonChildDoctor.invalidate()
                    smallButtonAdultDoctor.strokeWidth = 2
                    smallButtonAdultDoctor.strokeColor = resources.getColor(R.color.mainGreen)
                    smallButtonFamilyDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonFamilyDoctor.invalidate()
                    adapter.setData(LocalSpecializationRepository().getAdultSpecList())
                    recyclerSpec.show()
                }
                else -> {
                    smallButtonChildDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonChildDoctor.invalidate()
                    smallButtonAdultDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonAdultDoctor.invalidate()
                    smallButtonFamilyDoctor.strokeWidth = 2
                    smallButtonFamilyDoctor.strokeColor = resources.getColor(R.color.mainGreen)
                    adapter.setData(LocalSpecializationRepository().getFamilySpecList())
                    recyclerSpec.show()
                }
            }
            adapter.setOnItemViewClickListener {
                findNavController().navigate(R.id.action_doctorsListFragment_to_doctorListFragment,
                    Bundle().apply
                    { putParcelable(DoctorListFragment.SPEC_BUNDLE, it) })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}