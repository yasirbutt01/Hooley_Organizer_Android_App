package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.community.GetCommunityAlertsResponseModel
import com.hooleyapp.organizer.databinding.AdapterCommunityAlertsBinding

class AdapterCommunityAlerts(val context: Context, var mList: ArrayList<GetCommunityAlertsResponseModel.EventList>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    lateinit var binding: AdapterCommunityAlertsBinding
    private lateinit var mListener: ICommunityAlertClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_community_alerts, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.model = mList!![position]
        mHolder.binding.isSepratorShown = position != mList!!.size - 1
        mHolder.binding.executePendingBindings()
        mHolder.binding.rlMain.setOnClickListener {
            mListener.onClickCommunityAlerts(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterCommunityAlertsBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: ICommunityAlertClickListener) {
        mListener = listener
    }

    interface ICommunityAlertClickListener {
        fun onClickCommunityAlerts(position: Int)
    }

    fun getList () : ArrayList<GetCommunityAlertsResponseModel.EventList>{
        return mList!!
    }
}