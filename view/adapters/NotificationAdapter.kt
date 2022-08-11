package com.hooleyapp.organizer.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.notification.GetUserNotificationResponseModel
import com.hooleyapp.organizer.databinding.AdapterNotificationBinding

class NotificationAdapter(
    val context: Context, private val notificationsList: ArrayList<GetUserNotificationResponseModel.Notification>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: AdapterNotificationBinding
    private lateinit var mListener: INotificationClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_notification, parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return notificationsList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mHolder = holder as ItemViewHolder
        mHolder.binding.model = notificationsList!![position]
        mHolder.binding.isSepratorShown = position != notificationsList!!.size - 1
        mHolder.binding.executePendingBindings()
        mHolder.binding.rlMain.setOnClickListener {
            mListener.onClickNotifications(position)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: AdapterNotificationBinding = DataBindingUtil.bind(view)!!
    }

    fun setMyListener(listener: INotificationClickListener) {
        mListener = listener
    }

    fun getList(): ArrayList<GetUserNotificationResponseModel.Notification>? {
        return notificationsList
    }

    interface INotificationClickListener {
        fun onClickNotifications(position: Int)
    }
}