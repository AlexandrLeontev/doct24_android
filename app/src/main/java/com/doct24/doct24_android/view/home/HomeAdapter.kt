package com.doct24.doct24_android.view.home

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doct24.doct24_android.databinding.ItemHomeDoctorBinding
import com.doct24.doct24_android.model.Doctor
import com.doct24.doct24_android.model.Specialization
import com.doct24.doct24_android.model.localrepo.LocalDoctorsRepository
import com.squareup.picasso.Picasso

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var onItemViewClickListener: (Doctor) -> Unit = {}
    private var doctorsList: List<Doctor> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeDoctorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(doctorsList[position])
    }

    override fun getItemCount(): Int {
        return doctorsList.size
    }

    fun setOnItemViewClickListener(onItemViewClickListener: (Doctor) -> Unit){
        this.onItemViewClickListener = onItemViewClickListener
    }

    fun setData(){
        doctorsList = LocalDoctorsRepository().getDoctorsList(Specialization(0, "best"))
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: ItemHomeDoctorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: Doctor){
            with(binding){
                Picasso.get()
                    .load(doctor.avatar)
                    .fit()
                    .centerCrop(Gravity.TOP)
                    .into(doctorCardImage)
                doctorCardSpec.text = doctor.specialization

                root.setOnClickListener { onItemViewClickListener(doctor) }
            }
        }
    }

}