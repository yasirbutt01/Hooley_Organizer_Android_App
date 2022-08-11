package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.manageteam.GetManageEventResponseModel
import com.hooleyapp.organizer.databinding.AdapterManageStaffBinding
import com.hooleyapp.organizer.view.ui.main.events.manageteam.ManageStaffFragment

class AdapterManageStaff(
    val context: Context,
    var mList: ArrayList<GetManageEventResponseModel.User>?,
    var type: ManageStaffFragment.ManageAdapterType,
    var selectedUserList: ArrayList<GetManageEventResponseModel.User>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: AdapterManageStaffBinding
    private lateinit var mListener: IManageStaffClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_manage_staff, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.type = type
        mHolder.binding.isSelectedUser = selectedUserList!!.any { it.userId == mList!![position].userId }
        mHolder.binding.model = mList!![position]
        mHolder.binding.isSepratorShown = position != mList!!.size - 1
        mHolder.binding.executePendingBindings()
        mHolder.binding.ivCross.setOnClickListener {
            mListener.onClickCross(position)
        }
        mHolder.binding.rlMain.setOnClickListener {
            if (type == ManageStaffFragment.ManageAdapterType.ADD)
                mListener.onClickUser(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterManageStaffBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: IManageStaffClickListener) {
        mListener = listener
    }

    interface IManageStaffClickListener {
        fun onClickCross(position: Int)
        fun onClickUser(position: Int)
    }

    fun getList () : ArrayList<GetManageEventResponseModel.User>{
        return mList!!
    }
}