package com.hooleyapp.organizer.view.ui.main.communityalerts

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.responsemodels.community.GetMediaReportsDetailResponseModel
import com.hooleyapp.organizer.databinding.FragmentMediaPagerBinding
import com.hooleyapp.organizer.view.adapters.AdapterMediaPager
import com.hooleyapp.organizer.view.adapters.AdapterMediaPagerSmall
import com.hooleyapp.organizer.view.ui.base.ActivityBase
import com.hooleyapp.organizer.view.ui.base.BaseFragment
import com.hooleyapp.organizer.view.ui.main.HooleyOrganizerMain
import com.hooleyapp.organizer.view.ui.videoplayer.VideoPlayerActivity

class MediaPagerFragment : BaseFragment(), View.OnClickListener,
    AdapterMediaPagerSmall.IClickPostListener {

    lateinit var binding : FragmentMediaPagerBinding
    lateinit var adapterMedia : AdapterMediaPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_media_pager,container,false)
        setToolbar()
        setListener()
        setMediaAdapter(mediaList)
        return binding.root
    }

    fun setToolbar(){
        (ActivityBase.activity as HooleyOrganizerMain).hideToolbar()
    }

    private fun setListener(){
        binding.rlBack.setOnClickListener(this)
    }

    private fun setMediaAdapter(media : ArrayList<GetMediaReportsDetailResponseModel.Media>?){
        adapterMedia = AdapterMediaPager(media)
        adapterMedia.setMListener(this)
        binding.vpMedia.adapter = adapterMedia
        binding.vpMedia.currentItem = selectPosition
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.rlBack -> {
                ActivityBase.activity.onBackPressed()
            }
        }
    }


    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: MediaPagerFragment
        private var mediaList = ArrayList<GetMediaReportsDetailResponseModel.Media>()
        private var selectPosition = 0

        fun newInstance(
            list: ArrayList<GetMediaReportsDetailResponseModel.Media>,
            position: Int
        ): MediaPagerFragment {
            instance = MediaPagerFragment()
            mediaList = list
            selectPosition = position
            return instance
        }
    }

    override fun onClickPost(position: Int) {
        if (adapterMedia.getList()[position].isVideo){
            val mainIntent = Intent(HooleyOrganizerMain.mActivity, VideoPlayerActivity::class.java)
            mainIntent.putExtra("videoUrl", adapterMedia.getList()[position].url)
            ActivityBase.activity.startActivity(mainIntent)
        }
    }

}