package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.custommodel.ChartFilterModel
import com.hooleyapp.organizer.databinding.AdapterChartFilterBinding
import com.hooleyapp.organizer.utilities.extensions.dpToPx
import com.hooleyapp.organizer.utilities.extensions.getScreenWidth
import com.hooleyapp.organizer.view.ui.base.ActivityBase

class AdapterChartFilter (val context: Context, private val mList: ArrayList<ChartFilterModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterChartFilterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_chart_filter, parent, false)
        binding.root.layoutParams.width = ((ActivityBase.activity.getScreenWidth() - ActivityBase.activity.dpToPx(52)) / 7)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.bindWithData(mList[position].date)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterChartFilterBinding = DataBindingUtil.bind(view)!!
        fun bindWithData(item: String) {
           binding.tvDate.text = item
        }
    }

    fun getList(): ArrayList<ChartFilterModel> {
        return mList
    }
}