package com.doct24.doct24_android.view.patient.dataFragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentDataBinding


class DataFragment : Fragment() {
    lateinit var binding: FragmentDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = FragmentDataBinding.inflate(inflater)

        binding.cardAllerg.setOnClickListener(){
            Toast.makeText(requireContext(), "открыть данные", Toast.LENGTH_SHORT).show()

        }
        return binding.root
    }


}