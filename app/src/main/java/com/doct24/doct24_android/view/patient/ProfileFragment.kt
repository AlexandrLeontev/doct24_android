package com.doct24.doct24_android.view.patient

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.MainActivity
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentProfileBinding
import com.doct24.doct24_android.view.hide
import com.doct24.doct24_android.view.show
import kotlinx.android.synthetic.main.fragment_home.*

class ProfileFragment: Fragment() {

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


        with(binding){
            cardAllerg.setOnClickListener {
                showPopUpNotify()
            }
            cardMeds.setOnClickListener {
                showPopUpNotify()
            }
            cardDiseases.setOnClickListener {
                showPopUpNotify()
            }
            cardSurgeries.setOnClickListener {
                showPopUpNotify()
            }


        }


        return binding.root

    }

    private fun showPopUpNotify() {
        popUpFutureRelease.show()
        materialButton.setOnClickListener {
            popUpFutureRelease.hide()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

}