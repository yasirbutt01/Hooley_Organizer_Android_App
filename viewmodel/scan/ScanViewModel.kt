package com.hooleyapp.organizer.viewmodel.scan

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.ScanTicketRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.scan.GetScanStatsResponseModel
import com.hooleyapp.organizer.data.repository.scan.ScanRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class ScanViewModel(application : Application) : AndroidViewModel(application) {

    var repository = ScanRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetScanStatsResponseModel> = SingleLiveData()
    var objResponseGeneral: SingleLiveData<GeneralResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponse = repository.objResponse
        objResponseGeneral = repository.objResponseGeneral
    }

    fun getScanStats(eventId : String){
        repository.getScanStats(eventId = eventId)
    }

    fun scanTicket(obj : ScanTicketRequestModel){
        repository.scanTicket(obj = obj)
    }
}