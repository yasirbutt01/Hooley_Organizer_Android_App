package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.events.GetTotalRevenueTrasactionResponseModel
import com.hooleyapp.organizer.databinding.AdapterTotalRevenueBinding

class AdapterTotalRevenue(val context: Context, private val mList: ArrayList<GetTotalRevenueTrasactionResponseModel.Transactions>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {


    lateinit var binding: AdapterTotalRevenueBinding
    private lateinit var mListener: ISingleTicketRevenueClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_total_revenue ,parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.model = mList[position]
        mHolder.binding.isBottomShown = position != mList.size -1
        mHolder.binding.executePendingBindings()
        mHolder.binding.rlMain.setOnClickListener {
            mListener.onClickSingleTicketRevenue(position)
        }
    }


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterTotalRevenueBinding = DataBindingUtil.bind(view)!!
    }


    fun setMyListener(listener: ISingleTicketRevenueClickListener) {
        mListener = listener
    }
    fun getList () : ArrayList<GetTotalRevenueTrasactionResponseModel.Transactions>{
        return mList
    }

    interface ISingleTicketRevenueClickListener {
        fun onClickSingleTicketRevenue(position: Int)
    }
}