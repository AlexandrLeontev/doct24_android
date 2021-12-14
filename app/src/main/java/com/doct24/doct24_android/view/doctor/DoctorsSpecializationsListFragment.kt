package com.doct24.doct24_android.view.doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentDoctorsSpecialisationsListBinding
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
//        binding.recyclerSpec.adapter = adapter
//        adapter.setData()
//        adapter.setOnItemViewClickListener {
//            //переход к списку докторов по категории
//        }
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
                    smallButtonChildDoctor.strokeWidth = 2
                    smallButtonAdultDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonFamilyDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonChildDoctor.strokeColor = resources.getColor(R.color.mainGreen)
                }
                1 -> {
                    smallButtonChildDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonAdultDoctor.strokeWidth = 2
                    smallButtonFamilyDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonAdultDoctor.strokeColor = resources.getColor(R.color.mainGreen)
                }
                else -> {
                    smallButtonChildDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonAdultDoctor.strokeColor = resources.getColor(R.color.white)
                    smallButtonFamilyDoctor.strokeWidth = 2
                    smallButtonFamilyDoctor.strokeColor = resources.getColor(R.color.mainGreen)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}