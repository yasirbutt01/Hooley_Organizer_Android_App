package com.hooleyapp.organizer.viewmodel.more

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.AddFeedbackRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.more.GetContantResponseModel
import com.hooleyapp.organizer.data.repository.more.MoreRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class MoreViewModel  (application : Application) : AndroidViewModel(application) {

    var repository = MoreRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponseContant: SingleLiveData<GetContantResponseModel> = SingleLiveData()
    var objResponseGeneral: SingleLiveData<GeneralResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponseContant = repository.objResponseContant
        objResponseGeneral = repository.objResponseGeneral
    }

    fun getContant(type : Int){
        repository.getContant(type)
    }

    fun logout(){
        repository.logout()
    }

    fun addFeedback(obj : AddFeedbackRequestModel){
        repository.addFeedback(obj = obj)
    }
}