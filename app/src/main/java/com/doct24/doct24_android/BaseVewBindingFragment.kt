package com.doct24.doct24_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.util.zip.Inflater

abstract class BaseVewBindingFragment<VB: ViewBinding>(
        private val bindingInflater: (Inflater: LayoutInflater) ->VB
) :Fragment(){
    private var _binding: VB? = null
    val binding: VB
    get() = binding as VB

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = bindingInflater.invoke(inflater)
        if (_binding == null)
            throw IllegalArgumentException("Binding can not be null")
        return binding.root
    }

}