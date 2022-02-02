package com.doct24.doct24_android.view.doctor

import android.animation.ObjectAnimator
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.databinding.FragmentDoctorProfileBinding
import com.doct24.doct24_android.databinding.FragmentDoctorsListBinding
import com.doct24.doct24_android.model.Doctor
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_doctor_profile.*
import kotlinx.android.synthetic.main.fragment_vp_doctor_profile_entry.*
import androidx.viewpager.widget.ViewPager
import com.doct24.doct24_android.R


class DoctorProfileFragment : Fragment() {

    companion object {
        const val BUNDLE_DOCTOR = "doctor"
    }

    private var _binding: FragmentDoctorProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var doctor: Doctor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorProfileBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doctor = arguments?.getParcelable(BUNDLE_DOCTOR) ?:Doctor(0, "", "", "", "", 0, "", "", "",
        "", "", "", "", "", "", null, null)
        binding.doctorProfileBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        init()
        binding.doctorProfileAppointment.setOnClickListener {
            binding.doctorProfileEntryContainer.root.visibility = View.VISIBLE
            binding.doctorProfileFeedbackContainer.root.visibility = View.GONE
            binding.doctorProfileAboutContainer.root.visibility = View.GONE
        }
        binding.doctorProfileAbout.setOnClickListener {
            binding.doctorProfileAboutContainer.root.visibility = View.VISIBLE
            binding.doctorProfileFeedbackContainer.root.visibility = View.GONE
            binding.doctorProfileEntryContainer.root.visibility = View.GONE
        }
        binding.doctorProfileFeedback.setOnClickListener {
            binding.doctorProfileFeedbackContainer.root.visibility = View.VISIBLE
            binding.doctorProfileAboutContainer.root.visibility = View.GONE
            binding.doctorProfileEntryContainer.root.visibility = View.GONE
        }

    }

    private fun init() {
        with(binding){
            Picasso.get()
                .load(doctor.avatar)
                .into(doctorProfilePhoto)
            doctorProfileName.text = "${doctor.first_name} ${doctor.last_name}"
            doctorProfileAgeInput.text = "${doctor.age} лет"
            doctorProfileSpecInput.text = doctor.specialization
            doctorProfileLocationInput.text = "${doctor.country}, ${doctor.city}"


            doctorProfileFeedbackContainer.root.visibility = View.VISIBLE
            doctorProfileFeedbackContainer.progressProfessionality.progress = 80
            doctorProfileFeedbackContainer.progressResponsibility.progress = 90
            doctorProfileFeedbackContainer.progressAccurasy.progress = 75
            doctorProfileFeedbackContainer.progressPunctuality.progress = 60


            doctorProfileFeedbackContainer.doctorProfileRatingBar.rating = 4.75f
            doctorProfileFeedbackContainer.doctorProfileRatingText.text = doctorProfileFeedbackContainer.doctorProfileRatingBar.rating.toString()

            doctorProfileEntryContainer.buttonDoctorProfileChat.setOnClickListener {
//                buttonDoctorProfileChat.cardBackgroundColor = R.color.color_name
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}