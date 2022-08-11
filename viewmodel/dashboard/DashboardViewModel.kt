package com.hooleyapp.organizer.viewmodel.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.responsemodels.dashboard.GetDashboardResponseModel
import com.hooleyapp.organizer.data.repository.dashboard.DashboardRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class DashboardViewModel(application : Application) : AndroidViewModel(application) {

    var repository = DashboardRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetDashboardResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponse = repository.objResponse
    }

    fun getDashboard(start : String , end : String , isLoaderShown : Boolean){
        repository.getDashboard(start, end , isLoaderShown)
    }
}