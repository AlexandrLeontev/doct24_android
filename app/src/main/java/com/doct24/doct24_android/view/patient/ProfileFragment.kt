package com.doct24.doct24_android.view.patient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager.widget.ViewPager
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentProfileBinding
import com.doct24.doct24_android.view.patient.dataFragements.DataFragment
import com.doct24.doct24_android.view.patient.dataFragements.DocumentsFragment
import com.doct24.doct24_android.view.patient.dataFragements.SettingsFragment
import com.doct24.doct24_android.view.patient.dataFragements.adapters.ViewPagerAdapter

class ProfileFragment: Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
//    private val adapter = PatientAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)


        setUpTabs()
        return binding.root

    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(DataFragment(),"Данные")
        adapter.addFragment(DocumentsFragment(),"Документы")
        adapter.addFragment(SettingsFragment(),"Настройки")

        binding.viewPager.adapter = adapter
       binding.tabsData.setupWithViewPager(binding.viewPager)

    }


}