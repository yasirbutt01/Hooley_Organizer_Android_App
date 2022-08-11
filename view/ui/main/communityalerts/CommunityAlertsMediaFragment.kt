package com.hooleyapp.organizer.view.ui.main.communityalerts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.custommodel.ToolbarModel
import com.hooleyapp.organizer.data.model.responsemodels.community.GetCommunityAlertsResponseModel
import com.hooleyapp.organizer.databinding.FragmentCommunityAlertsMediaBinding
import com.hooleyapp.organizer.view.adapters.AdapterCommunityAlerts
import com.hooleyapp.organizer.view.ui.base.ActivityBase
import com.hooleyapp.organizer.view.ui.base.BaseFragment
import com.hooleyapp.organizer.view.ui.main.HooleyOrganizerMain
import com.hooleyapp.organizer.viewmodel.community.CommunityViewModel

class CommunityAlertsMediaFragment  : BaseFragment(),
    AdapterCommunityAlerts.ICommunityAlertClickListener {

    lateinit var binding : FragmentCommunityAlertsMediaBinding
    lateinit var viewModel: CommunityViewModel
    var adapter : AdapterCommunityAlerts? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_community_alerts_media,container,false)
        viewModel = ViewModelProviders.of(this).get(CommunityViewModel::class.java)
        setUiObserver()
        setToolbar()
        callMediaCommunityAlerts()
        return binding.root
    }

    fun setToolbar(){
        (ActivityBase.activity as HooleyOrganizerMain). setToolbar(
            ToolbarModel(model.name!! , isNotificationShown = false, isRightButtonShown = false, rightText = "",isBackShown = true)
        )
    }

    private fun setUiObserver() {
        viewModel.failureMessage.observe(this, Observer {
            it?.let { it ->
                setAdapter(arrayListOf())
            }
        })

        viewModel.objResponse.observe(this, Observer { obj ->
            setAdapter(obj.data!!.eventList)
        })
    }

    private fun callMediaCommunityAlerts(){
        viewModel.getMediaCommunityAlerts(model.id!!)
    }

    private fun setAdapter(eventListing: ArrayList<GetCommunityAlertsResponseModel.EventList>?) {
        val manager = LinearLayoutManager(ActivityBase.activity , LinearLayoutManager.VERTICAL,false)
        binding.rvCommunityAlertsMedia.layoutManager = manager
        adapter = AdapterCommunityAlerts(ActivityBase.activity, eventListing)
        adapter!!.setMyListener(this)
        binding.rvCommunityAlertsMedia.adapter = adapter
    }

    override fun onClickCommunityAlerts(position: Int) {
        callFragmentWithReplace(R.id.mainContainer,MediaReportsFragment.newInstance(adapter!!.getList()[position]),"MediaReportsFragment")
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: CommunityAlertsMediaFragment
        lateinit var model :GetCommunityAlertsResponseModel.EventList

        fun newInstance(report: GetCommunityAlertsResponseModel.EventList): CommunityAlertsMediaFragment {
            instance = CommunityAlertsMediaFragment()
            model = report
            return instance
        }
    }


}