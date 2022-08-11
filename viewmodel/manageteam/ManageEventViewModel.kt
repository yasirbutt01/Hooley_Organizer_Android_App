package com.hooleyapp.organizer.viewmodel.manageteam

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.AddUpdateManageEventRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.manageteam.GetManageEventResponseModel
import com.hooleyapp.organizer.data.repository.manageteam.ManageEventRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class ManageEventViewModel(application : Application) : AndroidViewModel(application) {

    var repository = ManageEventRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetManageEventResponseModel> = SingleLiveData()
    var objResponseGeneral: SingleLiveData<GeneralResponseModel> = SingleLiveData()

    init {
        objResponse = repository.objResponse
        failureMessage = repository.failureMessage
        objResponseGeneral = repository.objResponseGeneral
    }

    fun getManageEvent(eventId : String){
        repository.getManangeEvent(eventId = eventId)
    }

    fun searchUser(query : String , isLoaderShown : Boolean){
        repository.searchUser(query = query , isLoaderShown = isLoaderShown)
    }

    fun addUpdateManageEvent(obj : AddUpdateManageEventRequestModel){
        repository.addUpdateManageEvent(obj = obj)
    }
}