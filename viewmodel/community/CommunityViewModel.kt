package com.hooleyapp.organizer.viewmodel.community

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.DefaultOrDeleteAccountRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.community.GetCommunityAlertsResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.community.GetMediaReportsDetailResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.repository.community.CommunityRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class CommunityViewModel(application : Application) : AndroidViewModel(application) {

    var repository = CommunityRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetCommunityAlertsResponseModel> = SingleLiveData()
    var objResponseReportDetail: SingleLiveData<GetMediaReportsDetailResponseModel> = SingleLiveData()
    var objResponseGenearal: SingleLiveData<GeneralResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponse = repository.objResponse
        objResponseReportDetail = repository.objResponseReportDetail
        objResponseGenearal = repository.objResponseGenearal
    }

    fun getCommunityAlerts(){
        repository.getCommunityAlerts()
    }

    fun getMediaCommunityAlerts(eventId : String){
        repository.getMediaCommunityAlerts(eventId = eventId)
    }

    fun getMediaReportDetail(id : String){
        repository.getMediaReportsDetail(id = id)
    }

    fun deactivePost(obj : DefaultOrDeleteAccountRequestModel) {
        repository.deactivePost(obj = obj)
    }
}