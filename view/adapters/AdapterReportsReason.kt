package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.community.GetMediaReportsDetailResponseModel
import com.hooleyapp.organizer.databinding.AdapterReportsReasonBinding

class AdapterReportsReason(val context: Context, private val mList: ArrayList<GetMediaReportsDetailResponseModel.Report>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    lateinit var binding: AdapterReportsReasonBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_reports_reason ,parent, false)
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
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterReportsReasonBinding = DataBindingUtil.bind(view)!!
    }
}