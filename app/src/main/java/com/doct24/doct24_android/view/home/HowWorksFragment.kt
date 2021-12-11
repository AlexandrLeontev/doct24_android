package com.doct24.doct24_android.view.home

import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentHowWorksBinding

class HowWorksFragment : Fragment() {

    private var _binding: FragmentHowWorksBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHowWorksBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            howWorksBackButton.setOnClickListener {
                findNavController().popBackStack()
            }
            val spannableTitle1 =
                SpannableString(resources.getString(R.string.howDoct24WorksTitle1))
            spannableTitle1.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.mainGreen)),
                (spannableTitle1.length - 2), (spannableTitle1.length),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            howWorksTitle1.text = spannableTitle1
            val spannableText1 = SpannableString(resources.getString(R.string.howDoct24WorksText1))
            spannableText1.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.mainGreen)),
                4, 6,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            howWorksText1.text = spannableText1
            val spannableTitle2 =
                SpannableString(resources.getString(R.string.howDoct24WorksTitle2))
            spannableTitle2.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.mainGreen)),
                (spannableTitle2.length - 3), (spannableTitle2.length - 1),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            howWorksTitle2.text = spannableTitle2
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}