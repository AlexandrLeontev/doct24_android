package com.doct24.doct24_android.view.patient

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.NumberPicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.FragmentProfileBinding
import com.doct24.doct24_android.view.hide
import com.doct24.doct24_android.view.patient.dataFragments.PatientDataFragment
import com.doct24.doct24_android.view.show
import kotlinx.android.synthetic.main.dialog_layout_custom.view.*
import kotlinx.android.synthetic.main.fragment_home.materialButton
import kotlinx.android.synthetic.main.fragment_home.popUpFutureRelease
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    companion object {
        const val PATIENT_HEIGHT = "Рост"
        const val PATIENT_WEIGHT = "Вес"
        const val PATIENT_BLOOD_TYPE = "Группа крови"

        //image pick code
        private val IMAGE_PICK_CODE = 1000

        //Permission code
        private val PERMISSION_CODE = 1001
    }

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)


        with(binding) {
            cardHeght.setOnClickListener {
                showDialogFragment(PATIENT_HEIGHT, 50, 250)
            }
            cardWaight.setOnClickListener {
                showDialogFragment(PATIENT_WEIGHT, 30, 200)
            }
            cardBlood.setOnClickListener {
                showDialogFragment(PATIENT_BLOOD_TYPE, 0, 0)
            }
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
            enterName.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_patientDataFragment)
            }

            imPrfilePhoto.setOnClickListener {
                pickImageFromGallery()
//                //check runtime permission
//                if (VERSION.SDK_INT >= VERSION_CODES.M){
//                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
//                            PackageManager.PERMISSION_DENIED){
//                        //permission denied
//                        val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
//                        //show popup to request runtime permission
//                        requestPermissions(permissions, PERMISSION_CODE);
//                    }
//                    else{
//                        //permission already granted
//                        pickImageFromGallery();
//                    }
//                }
//                else{
//                    //system OS is < Marshmallow
//                    pickImageFromGallery();
//                }
            }

            profileViewModel.image.observe(viewLifecycleOwner) {
//                binding.imPrfilePhoto.id = it
                im_prfile_photo.setImageURI(it)
            }

            profileViewModel.getImage()

        }

        return binding.root

    }

    private fun showDialogFragment(title: String, minValue: Int, maxValue: Int) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_layout_custom, null)
        val dialogAlert = AlertDialog.Builder(requireActivity())
            .setView(dialogView)
            .show()
        dialogAlert.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
        val buttonAccept = dialogView.findViewById<ImageButton>(R.id.buttonAccept)
        dialogView.textView.text = title
        val numberPicker = dialogView.findViewById<NumberPicker>(R.id.numberPicker)
        if (minValue > 0) {
            numberPicker.minValue = minValue
            numberPicker.maxValue = maxValue
        } else {
            val values = arrayOf(
                "O (I) Rh+",
                "O (I) Rh-",
                "A (II) Rh+",
                "А (II) Rh-",
                "B (III) Rh+",
                "B (III) Rh-",
                "AB (IV) Rh-"
            )
            numberPicker.minValue = 0
            numberPicker.maxValue = values.size - 1
            numberPicker.displayedValues = values
        }
        numberPicker.wrapSelectorWheel = true
        buttonAccept.setOnClickListener {
            dialogAlert.dismiss()
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
//            im_prfile_photo.setImageURI(data?.data)
            data?.data?.let(profileViewModel::setImage)
//            profileViewModel.image.postValue(data?.)
        }

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

