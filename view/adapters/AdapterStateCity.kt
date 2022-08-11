package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import androidx.databinding.DataBindingUtil
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.custommodel.GetCityStateModel
import com.hooleyapp.organizer.databinding.AdapterCitiesBinding
import com.hooleyapp.organizer.databinding.AdapterStateCityBinding
import java.util.*

/**
 * Created by Nauman on 5/3/2018.
 */

class AdapterStateCity(
    private val elvStateCity: ExpandableListView,
    private val context: Context,
    var mlist: ArrayList<GetCityStateModel.StateCity>
) : BaseExpandableListAdapter() {
    lateinit var childBinding: AdapterCitiesBinding
    lateinit var parentBinding: AdapterStateCityBinding
    lateinit var mListener: IStateCityClickListener

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return mlist[groupPosition].citiesList[childPosition]

    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        childBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_cities, parent, false)
        convertView = childBinding.root
        convertView.tag = childBinding
        childBinding.model = mlist[groupPosition].citiesList[childPosition]
        childBinding.rlStates.setOnClickListener {
            mListener.onChildCheckChange(!mlist[groupPosition].citiesList[childPosition].isChecked, groupPosition, childPosition)
        }
        return convertView

    }


    override fun getChildrenCount(groupPosition: Int): Int {
        return mlist[groupPosition].citiesList.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return mlist[groupPosition]
    }

    override fun getGroupCount(): Int {
        return mlist.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        parentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_state_city, parent, false)
        convertView = parentBinding.root
        convertView.tag = parentBinding
        mlist[groupPosition].isExpand = elvStateCity.isGroupExpanded(groupPosition)
        parentBinding.model = mlist[groupPosition]
        parentBinding.executePendingBindings()
        parentBinding.ivCheck.setOnClickListener {
            mListener.onParentCheckChange(!mlist[groupPosition].selectAll , groupPosition)
        }
        return convertView

    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    fun setListener(listener: IStateCityClickListener) {
        this.mListener = listener
    }

    interface IStateCityClickListener {
        fun onClickParent(isExpanded: Boolean, position: Int)

        fun onParentCheckChange(isChecked: Boolean, position: Int)

        fun onChildCheckChange(isChecked: Boolean, groupPosition: Int, childPosition: Int)

    }

    fun getList(): ArrayList<GetCityStateModel.StateCity> {
        return mlist
    }
}

