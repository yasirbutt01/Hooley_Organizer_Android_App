package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.wallet.GetMyTransactionsResponseModel
import com.hooleyapp.organizer.databinding.AdapterTransactionHistoryBinding

class TransactionHistoryAdapter(val context: Context, private val mList: ArrayList<GetMyTransactionsResponseModel.Transaction>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterTransactionHistoryBinding
    private lateinit var mListener: IHistoryListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_transaction_history, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.model = mList[position]
        mHolder.binding.executePendingBindings()
        mHolder.binding.cvMain.setOnClickListener {
            mListener.onClickHistory(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterTransactionHistoryBinding = DataBindingUtil.bind(view)!!

    }

    fun setMyListener(listener: IHistoryListener) {
        mListener = listener
    }

    fun getList(): ArrayList<GetMyTransactionsResponseModel.Transaction> {
        return mList
    }
    interface IHistoryListener {
        fun onClickHistory(position: Int)
    }
}