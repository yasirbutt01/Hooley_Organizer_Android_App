package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.custommodel.PlaidInfo
import com.hooleyapp.organizer.databinding.AdapterPlaidAccountBinding

class AdapterPlaidAccount(
    val context: Context,
    val mList: ArrayList<PlaidInfo>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    lateinit var binding: AdapterPlaidAccountBinding
    private lateinit var mListener: IMethodClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.adapter_plaid_account,
            parent,
            false
        )
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.model = mList!![position]
        mHolder.binding.isSepratorShow = position != mList.size -1
        mHolder.binding.executePendingBindings()

        mHolder.binding.rlMain.setOnClickListener {
            mListener.onClickAccount(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterPlaidAccountBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: IMethodClick) {
        mListener = listener
    }

    fun getList(): ArrayList<PlaidInfo> {
        return mList!!
    }

    interface IMethodClick {
        fun onClickAccount(position: Int)
    }
}