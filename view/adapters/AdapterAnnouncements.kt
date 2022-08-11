package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.announcement.GetAnnouncementResponseModel
import com.hooleyapp.organizer.databinding.AdapterAnnouncementBinding

class AdapterAnnouncements(val context: Context, private val mList: ArrayList<GetAnnouncementResponseModel.Annoucements>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    lateinit var binding: AdapterAnnouncementBinding
    private lateinit var listener : IMoreSelectClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_announcement ,parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.model = mList!![position]
        mHolder.binding.isSepratorShown = position != mList.size - 1
        mHolder.binding.executePendingBindings()
        mHolder.binding.ivMore.setOnClickListener {
            listener.onClickMore(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterAnnouncementBinding = DataBindingUtil.bind(view)!!
    }

    fun getList(): ArrayList<GetAnnouncementResponseModel.Annoucements>? {
        return mList
    }

    fun setMyListener(listener: IMoreSelectClickListener) {
        this.listener = listener
    }
    interface IMoreSelectClickListener {
        fun onClickMore(pos: Int)
    }

}