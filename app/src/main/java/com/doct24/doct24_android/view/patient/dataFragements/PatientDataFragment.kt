package com.doct24.doct24_android.view.patient.dataFragements

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.doct24.doct24_android.MainActivity
import com.doct24.doct24_android.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class PatientDataFragment : Fragment() {

//    private lateinit var viewModel: PatientDataViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.patient_data_fragment, container, false)

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(PatientDataViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}