package com.doct24.doct24_android.view.patient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doct24.doct24_android.databinding.PatientDataElementBinding


class PatientAdapter: RecyclerView.Adapter<PatientAdapter.PatientHolder>() {

    val patientDataList = ArrayList<PatientData>()

    class PatientHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = PatientDataElementBinding.bind(item)
        fun bind(patientData: PatientData)  {
            binding.tvElement.text = patientData.title
            binding.im.setImageResource(patientData.imageID)

        }
    }
    fun submitList(newList: List<PatientData>){
        patientDataList.clear()
        patientDataList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientHolder {
        val  view = LayoutInflater.from(parent.context).inflate(com.doct24.doct24_android.R.layout.patient_data_element,parent, false)
        return PatientHolder(view)
    }

    override fun onBindViewHolder(holder: PatientHolder, position: Int) {
     holder.bind(patientDataList[position])
    }

    override fun getItemCount(): Int {
       return patientDataList.size
    }
}