package com.hooleyapp.organizer.viewmodel.announcement

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.AddUpdateAnnouncementRequestModel
import com.hooleyapp.organizer.data.model.requestmodel.DeleteAnnouncementRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.announcement.GetAnnouncementResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.repository.announcement.AnnouncementRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class AnnouncementViewModel(application : Application) : AndroidViewModel(application)  {

    var repository = AnnouncementRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetAnnouncementResponseModel> = SingleLiveData()
    var objResponseAddUpdate: SingleLiveData<GeneralResponseModel> = SingleLiveData()

    init {
        objResponse = repository.objResponse
        failureMessage = repository.failureMessage
        objResponseAddUpdate = repository.objResponseAddUpdate
    }

    fun getAnnouncement(eventId : String){
        repository.getAnnouncement(eventId)

    }

    fun addUpdateAnnouncement(cameraUri : Uri?, model : AddUpdateAnnouncementRequestModel){
        repository.addUpdateAnnouncement(cameraUri , model)
    }

    fun deleteAnnouncement(obj : DeleteAnnouncementRequestModel){
        repository.deleteAnnouncement(obj = obj)
    }
}