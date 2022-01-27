package com.doct24.doct24_android.view.meeting

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doct24.doct24_android.databinding.ItemFutureMeetingListBinding
import com.doct24.doct24_android.model.Meeting
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class MeetingListAdapter : RecyclerView.Adapter<MeetingListAdapter.MeetingListViewHolder>() {

    private var meetingList: List<Meeting> = listOf()

    fun setData(data: List<Meeting>) {
        meetingList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingListViewHolder {
        val binding = ItemFutureMeetingListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MeetingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeetingListViewHolder, position: Int) {
        holder.bind(meetingList[position])
    }

    override fun getItemCount(): Int {
        return meetingList.size
    }

    inner class MeetingListViewHolder(private val binding: ItemFutureMeetingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meeting: Meeting) {

            val validUntil = meeting.date
            val sdf = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            val strDate: Date? = sdf.parse(validUntil)
            if (strDate != null) {
                if (System.currentTimeMillis() > strDate.time) {
                    binding.meetingListDate.setTextColor(Color.BLUE)
                } else
                    binding.meetingListDate.setTextColor(Color.YELLOW)
            }
            with(binding) {
                val docName = "${meeting.doctor.first_name} ${meeting.doctor.last_name}"
                Picasso.get()
                    .load(meeting.doctor.avatar)
                    .into(meetingListDoctorPhoto)
                meetingListDoctorName.text = docName
                meetingListDate.text = meeting.date
                meetingListDoctorSpec.text = meeting.doctor.specialization
                meetingListTime.text = meeting.time
                if (meeting.accepted) {
                    meetingListPaidStatus.text = "Оплачено"
                    meetingListPaidStatus.setTextColor(Color.GREEN)
                    meetingListStartButton.text = "Начать"
                } else {
                    meetingListPaidStatus.text = "Не оплачено"
                    meetingListPaidStatus.setTextColor(Color.RED)
                    meetingListStartButton.text = "Оплатить"
                }
            }
        }
    }
}