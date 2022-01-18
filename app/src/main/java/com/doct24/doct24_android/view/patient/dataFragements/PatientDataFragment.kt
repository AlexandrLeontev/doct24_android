package com.doct24.doct24_android.view.patient.dataFragements

import android.app.DatePickerDialog

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.databinding.FragmentPatientDataBinding
import kotlinx.android.synthetic.main.fragment_patient_data.*
import java.util.*



class PatientDataFragment : Fragment() {

    private var _binding: FragmentPatientDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPatientDataBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)

        with(binding) {
           cardBirthday.setOnClickListener {
                   birthdayListener()
               }
           cardEnterEmail.setOnFocusChangeListener { v, hasFocus ->
               if (!hasFocus){
                   binding.emailContainer.helperText = validEmail()
               }
           }

           }


        return  binding.root
    }

    private fun validEmail(): String? {
        val emailText = binding.etPatientEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Неправильный e-mail адрес"
        }
        return null

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.patientDataBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun birthdayListener(){
        binding.cardBirthday.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                editTextDate.setText("" + dayOfMonth + "." + (monthOfYear +1)+ "." + year)

            }, year, month, day)

            dpd.show()
        }

    }



}