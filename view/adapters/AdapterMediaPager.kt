package com.hooleyapp.organizer.view.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.community.GetMediaReportsDetailResponseModel
import com.hooleyapp.organizer.databinding.AdapterMediaPagerBinding
import com.hooleyapp.organizer.view.ui.base.ActivityBase

class AdapterMediaPager(val mList : ArrayList<GetMediaReportsDetailResponseModel.Media>?): PagerAdapter() {

    private var mlistener: AdapterMediaPagerSmall.IClickPostListener? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater = ActivityBase.activity.layoutInflater
        val binding : AdapterMediaPagerBinding = DataBindingUtil.inflate(inflater,
            R.layout.adapter_media_pager,container,false)
        binding.model = mList!![position]
        binding.rlMain.setOnClickListener {
            mlistener!!.onClickPost(position)
        }
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

    override fun getCount(): Int {
        return mList!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    fun removeView(pager: ViewPager, position: Int): Int {
        pager.adapter = null
        mList!!.removeAt(position)
        pager.adapter = this
        return position
    }

    fun setMListener(listener: AdapterMediaPagerSmall.IClickPostListener) {
        mlistener = listener
    }

    fun getList(): ArrayList<GetMediaReportsDetailResponseModel.Media> {
        return mList!!
    }


}