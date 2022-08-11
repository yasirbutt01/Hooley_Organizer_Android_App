package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.hooleyapp.organizer.HooleyApp
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.custommodel.GetCityStateModel
import com.hooleyapp.organizer.databinding.AdapterSelectedStatesBinding
import com.hooleyapp.organizer.utilities.Constants

class AdapterSelectedStates (val context: Context, private val mList: ArrayList<GetCityStateModel.StateCity>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterSelectedStatesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_selected_states ,parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mList!!.map { it.citiesList = ArrayList(it.citiesList.filter { it.isChecked }) }
        mHolder.binding.model = mList!![position]
        mHolder.binding.isSepratorShown = position != mList!!.size - 1
        mHolder.binding.executePendingBindings()
        mHolder.binding.ivCross.setOnClickListener {
            val model = Gson().fromJson(
                HooleyApp.db.getString(Constants.STATE_CITY_RESPONSE),
                GetCityStateModel::class.java
            )
            model.statesWithCitiesList[model.statesWithCitiesList.indexOfFirst { it.id == mList[position].id }].selectAll = false
            model.statesWithCitiesList[model.statesWithCitiesList.indexOfFirst { it.id == mList[position].id }].multiSelect = false
            model.statesWithCitiesList[model.statesWithCitiesList.indexOfFirst { it.id == mList[position].id }].citiesList.map { it.isChecked = false }
            HooleyApp.db.putString(
                Constants.STATE_CITY_RESPONSE,
                Gson().toJson(model, GetCityStateModel::class.java).toString()
            )
            mList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    fun getList(): ArrayList<GetCityStateModel.StateCity>? {
        return mList
    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterSelectedStatesBinding = DataBindingUtil.bind(view)!!
    }
}