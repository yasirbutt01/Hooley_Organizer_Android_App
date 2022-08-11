package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.promotion.GetEventPromoteResponseModel
import com.hooleyapp.organizer.databinding.AdapterPromotionCardBinding

class AdapterPromotionCard(
    val context: Context,
    val mList: ArrayList<GetEventPromoteResponseModel.Card>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()   {


    lateinit var binding: AdapterPromotionCardBinding
    private lateinit var mListener: ICardClick
    private var viewBindHelper: ViewBinderHelper = ViewBinderHelper()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        viewBindHelper.setOpenOnlyOne(true)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_promotion_card, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.card = mList!![position]
        mHolder.binding.executePendingBindings()
        mHolder.binding.btnPayNow.setOnClickListener {
            mListener.onClickCard(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterPromotionCardBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: ICardClick) {
        mListener = listener
    }

    fun getList(): ArrayList<GetEventPromoteResponseModel.Card> {
        return mList!!
    }

    interface ICardClick {
        fun onClickCard(position: Int)
    }
}