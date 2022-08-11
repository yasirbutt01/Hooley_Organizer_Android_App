package com.hooleyapp.organizer.viewmodel.notification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.responsemodels.notification.GetUserNotificationResponseModel
import com.hooleyapp.organizer.data.repository.notification.NotificationRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class NotificationViewModel(application : Application) : AndroidViewModel(application) {

    var repository = NotificationRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetUserNotificationResponseModel> = SingleLiveData()

    init {
        objResponse = repository.objResponse
        failureMessage = repository.failureMessage
    }

    fun getNotifications(){
        repository.getNotifications()
    }
}