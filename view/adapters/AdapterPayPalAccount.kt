package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.wallet.GetPayPalAccountsResponseModel
import com.hooleyapp.organizer.databinding.AdapterPaypalAccountBinding

class AdapterPayPalAccount(
    val context: Context,
    val forDefault: Boolean,
    val mList: ArrayList<GetPayPalAccountsResponseModel.Accounts>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterPaypalAccountBinding
    private lateinit var mListener: IMethodClick
    private var viewBindHelper: ViewBinderHelper = ViewBinderHelper()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        viewBindHelper.setOpenOnlyOne(true)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_paypal_account, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        viewBindHelper.bind(binding.srLayout, "1")
        if (forDefault)
            mHolder.binding.srLayout.setLockDrag(true)
        else
            mHolder.binding.srLayout.setLockDrag(false)
        mHolder.binding.model = mList!![position]
        mHolder.binding.isSepratorShow = position != mList.size -1
        mHolder.binding.executePendingBindings()
        mHolder.binding.llDelete.setOnClickListener {
            mHolder.binding.srLayout.close(true)
            viewBindHelper.bind(binding.srLayout, "1")
            mListener.onClickDelete(position)
        }


        mHolder.binding.rlMain.setOnClickListener {
            mListener.onClickAccount(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterPaypalAccountBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: IMethodClick) {
        mListener = listener
    }

    fun getList(): ArrayList<GetPayPalAccountsResponseModel.Accounts> {
        return mList!!
    }

    interface IMethodClick {
        fun onClickDelete(position: Int)
        fun onClickAccount(position: Int)
    }
}