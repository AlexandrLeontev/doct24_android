package com.doct24.doct24_android.view.doctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doct24.doct24_android.databinding.ItemDoctorListBinding
import com.doct24.doct24_android.model.Doctor
import com.doct24.doct24_android.model.Specialization
import com.doct24.doct24_android.model.localrepo.LocalDoctorsRepository
import com.squareup.picasso.Picasso

class DoctorListAdapter : RecyclerView.Adapter<DoctorListAdapter.DoctorListViewHolder>() {

    private var onItemViewClickListener: (Doctor) -> Unit = {}
    private var doctorsList: List<Doctor> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoctorListAdapter.DoctorListViewHolder {
        val binding = ItemDoctorListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return DoctorListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorListAdapter.DoctorListViewHolder, position: Int) {
        holder.bind(doctorsList[position])
    }

    override fun getItemCount(): Int {
        return doctorsList.size
    }

    fun setOnItemViewClickListener(onItemViewClickListener: (Doctor) -> Unit) {
        this.onItemViewClickListener = onItemViewClickListener
    }

    fun setData(spec: Specialization){
        doctorsList = LocalDoctorsRepository().getDoctorsList(spec)
        notifyDataSetChanged()
    }

    inner class DoctorListViewHolder(private val binding: ItemDoctorListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: Doctor) {
            with(binding) {
                Picasso.get()
                    .load(doctor.avatar)
                    .into(doctorListPhoto)
                doctorListName.text = "${doctor.first_name} ${doctor.last_name}"
                doctorListDegree.text = doctor.degree
                root.setOnClickListener { onItemViewClickListener(doctor) }
            }
        }
    }
}