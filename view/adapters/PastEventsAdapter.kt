package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.events.GetEventsListResponseModel
import com.hooleyapp.organizer.databinding.AdapterEventsBinding

class PastEventsAdapter(val context: Context, var mList: ArrayList<GetEventsListResponseModel.EventListing>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterEventsBinding
    private lateinit var mListener: IUpEventClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_events, parent, false)
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
            mListener.onClickPastEvent(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterEventsBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: IUpEventClickListener) {
        mListener = listener
    }

    interface IUpEventClickListener {
        fun onClickPastEvent(position: Int)
    }

    fun getList () : ArrayList<GetEventsListResponseModel.EventListing>{
        return mList!!
    }
}