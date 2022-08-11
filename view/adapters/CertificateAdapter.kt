package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.GetCertificatesModel
import com.hooleyapp.organizer.databinding.AdapterCertificateBinding

class CertificateAdapter(val context: Context, private val mList: ArrayList<GetCertificatesModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterCertificateBinding
    private lateinit var mListener: ICertificateListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_certificate, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.bindWithData(mList[position])

        if (position == mList.size - 1) {
            mHolder.binding.vBottom.visibility = View.GONE
        } else {
            mHolder.binding.vBottom.visibility = View.VISIBLE
        }

        mHolder.binding.rlMain.setOnClickListener {
            mListener.onClickCertificate(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterCertificateBinding = DataBindingUtil.bind(view)!!

        fun bindWithData(item: GetCertificatesModel) {
            if (item.isSelected)
                binding.rlSelection.visibility = View.VISIBLE
            else
                binding.rlSelection.visibility = View.GONE
        }
    }

    fun setMyListener(listener: ICertificateListener) {
        mListener = listener
    }

    interface ICertificateListener {
        fun onClickCertificate(position: Int)
    }
}