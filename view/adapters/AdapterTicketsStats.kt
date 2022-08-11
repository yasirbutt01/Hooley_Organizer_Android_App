package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.events.GetTicketSalesResponseModel
import com.hooleyapp.organizer.databinding.AdapterTicketStatsHeaderBinding
import com.hooleyapp.organizer.databinding.AdapterTicketsStatsBinding

class AdapterTicketsStats(
    val context: Context,
    private val mList: ArrayList<GetTicketSalesResponseModel.General>?,
    private val ppvList: ArrayList<GetTicketSalesResponseModel.Ppv>?,
    private val charity: GetTicketSalesResponseModel.Charity?,
    var totalRevnue: Double
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterTicketsStatsBinding
    lateinit var headerBinding: AdapterTicketStatsHeaderBinding
    private lateinit var mListener: ITicketStatsClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0){
            headerBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_ticket_stats_header ,parent, false)
            HeaderItemViewHolder(headerBinding.root)
        }else {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_tickets_stats ,parent, false)
            ItemViewHolder(binding.root)
        }
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0){
            val mHolder = holder as HeaderItemViewHolder
            mHolder.binding.totalRevenue = totalRevnue
            mHolder.binding.charity = charity
            mHolder.binding.ppv = ppvList
            mHolder.binding.executePendingBindings()
            mHolder.binding.rlTotalRevenue.setOnClickListener {
                mListener.onClickTotalRevenue()
            }
            mHolder.binding.cvPpv.setOnClickListener {
                mListener.onClickPpv()
            }
            mHolder.binding.rvPpv.setOnClickListener {
                mListener.onClickPpv()
            }
        }else {
            val mHolder = holder as ItemViewHolder
            mHolder.binding.model = mList!![position]
            mHolder.binding.executePendingBindings()
            mHolder.binding.cvTicket.setOnClickListener {
                mListener.onClickSingleTicket(position)
            }
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterTicketsStatsBinding = DataBindingUtil.bind(view)!!

    }

    class HeaderItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterTicketStatsHeaderBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: ITicketStatsClickListener) {
        mListener = listener
    }

    fun getList(): ArrayList<GetTicketSalesResponseModel.General> {
        return mList!!
    }

    fun getPpv(): ArrayList<GetTicketSalesResponseModel.Ppv>? {
        return ppvList
    }

    interface ITicketStatsClickListener {
        fun onClickTotalRevenue()
        fun onClickSingleTicket(position: Int)
        fun onClickPpv()
    }
}