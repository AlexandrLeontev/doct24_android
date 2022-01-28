package com.doct24.doct24_android.view.meeting

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doct24.doct24_android.R
import com.doct24.doct24_android.databinding.ItemMeetingListBinding
import com.doct24.doct24_android.model.Meeting
import com.squareup.picasso.Picasso

class MeetingListAdapter : RecyclerView.Adapter<MeetingListAdapter.MeetingListViewHolder>() {

    private var meetingList: List<Meeting> = listOf()
    private var isFuture: Boolean = true

    fun setData(data: List<Meeting>, isFuture: Boolean) {
        this.isFuture = isFuture
        meetingList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingListViewHolder {
        val binding = ItemMeetingListBinding.inflate(
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

    inner class MeetingListViewHolder(private val binding: ItemMeetingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val resources: Resources = this.itemView.resources
        fun bind(meeting: Meeting) {
            with(binding) {
                val docName = "${meeting.doctor.first_name} ${meeting.doctor.last_name}"
                Picasso.get()
                    .load(meeting.doctor.avatar)
                    .into(meetingListDoctorPhoto)
                meetingListDoctorName.text = docName
                meetingListDoctorSpec.text = meeting.doctor.specialization
                meetingListDate.text = meeting.date
            }
            if (isFuture) {
                with(binding) {
                    meetingListStartButton.visibility = View.VISIBLE
                    meetingListChangeButton.text = resources.getText(R.string.change)

                    meetingListTime.text = meeting.time
                    meetingListTime.setTextColor(resources.getColor(R.color.mainGreen))
                    meetingListPaidStatus.visibility = View.VISIBLE
                    if (meeting.accepted) {
                        meetingListPaidStatus.text = resources.getText(R.string.paid)
                        meetingListPaidStatus.setTextColor(resources.getColor(R.color.mainGreen))
                        meetingListStartButton.text = resources.getText(R.string.start)
                    } else {
                        meetingListPaidStatus.text = resources.getText(R.string.not_paid)
                        meetingListPaidStatus.setTextColor(resources.getColor(R.color.attention_color_red))
                        meetingListStartButton.text = resources.getText(R.string.pay)
                    }
                }
            } else {
                with(binding) {
                    meetingListPaidStatus.visibility = View.GONE
                    meetingListStartButton.visibility = View.GONE
                    meetingListType.visibility = View.GONE
                    meetingListChangeButton.text = resources.getText(R.string.rebook)
                    meetingListTime.setTextColor(resources.getColor(R.color.attention_color_red))
                    meetingListTime.text = resources.getText(R.string.canceled)
                }
            }
        }
    }
}