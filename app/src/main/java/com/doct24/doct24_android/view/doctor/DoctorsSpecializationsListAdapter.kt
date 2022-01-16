package com.doct24.doct24_android.view.doctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doct24.doct24_android.databinding.ItemSpecializationBinding
import com.doct24.doct24_android.model.Specialization
import com.doct24.doct24_android.model.localrepo.LocalSpecializationRepository

class DoctorsSpecializationsListAdapter :
    RecyclerView.Adapter<DoctorsSpecializationsListAdapter.DoctorsSpecializationsListViewHolder>() {

    private var onItemViewClickListener: (Specialization) -> Unit = {}
    private var specializationList: List<Specialization> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoctorsSpecializationsListViewHolder {
        val binding = ItemSpecializationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DoctorsSpecializationsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorsSpecializationsListViewHolder, position: Int) {
        holder.bind(specializationList[position])
    }

    override fun getItemCount(): Int {
        return specializationList.size
    }

    fun setOnItemViewClickListener(onItemViewClickListener: (Specialization) -> Unit) {
        this.onItemViewClickListener = onItemViewClickListener
    }

    fun setData(data: List<Specialization>) {
        specializationList = data
        notifyDataSetChanged()
    }

    inner class DoctorsSpecializationsListViewHolder(private val binding: ItemSpecializationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(specialization: Specialization) {
            binding.specName.text = specialization.title
            binding.root.setOnClickListener { onItemViewClickListener(specialization) }
        }
    }
}