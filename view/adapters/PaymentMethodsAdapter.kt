package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.wallet.GetAccountsResponseModel
import com.hooleyapp.organizer.databinding.AdapterPayMethodsBinding

class PaymentMethodsAdapter(
    val context: Context,
    private val mList: ArrayList<GetAccountsResponseModel.Accounts>,
    val forDefault: Boolean
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterPayMethodsBinding
    private lateinit var mListener: IMethodClick
    private var viewBindHelper: ViewBinderHelper = ViewBinderHelper()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        viewBindHelper.setOpenOnlyOne(true)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_pay_methods, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        viewBindHelper.bind(binding.srLayout, mList[position].id.toString())
        if (forDefault)
            mHolder.binding.srLayout.setLockDrag(true)
        else
            mHolder.binding.srLayout.setLockDrag(false)
        mHolder.binding.model = mList[position]
        mHolder.binding.executePendingBindings()
        mHolder.binding.llDelete.setOnClickListener {
            mHolder.binding.srLayout.close(true)
            viewBindHelper.bind(binding.srLayout, mList[position].id.toString())
            mListener.onClickDelete(position)
        }

        mHolder.binding.llDefault.setOnClickListener {
            mHolder.binding.srLayout.close(true)
            viewBindHelper.bind(binding.srLayout, mList[position].id.toString())
            mListener.onClickMakeDefault(position)
        }
        mHolder.binding.rlMain.setOnClickListener {
            mListener.onClickAccount(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterPayMethodsBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: IMethodClick) {
        mListener = listener
    }

    fun getList(): ArrayList<GetAccountsResponseModel.Accounts> {
        return mList
    }

    interface IMethodClick {
        fun onClickDelete(position: Int)
        fun onClickMakeDefault(position: Int)
        fun onClickAccount(position: Int)
    }
}