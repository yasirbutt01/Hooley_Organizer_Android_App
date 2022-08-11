package com.hooleyapp.organizer.viewmodel.promotion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.SavePromotionRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.promotion.GetEventPromoteResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.promotion.GetPromotionStatsResponseModel
import com.hooleyapp.organizer.data.repository.promotion.PromotionRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class PromotionViewModel(application : Application) : AndroidViewModel(application) {

    var repository = PromotionRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetEventPromoteResponseModel> = SingleLiveData()
    var objResponseSavePromotion: SingleLiveData<GeneralResponseModel> = SingleLiveData()
    var objResponseGetPromotionStats: SingleLiveData<GetPromotionStatsResponseModel> = SingleLiveData()

    init {
        objResponse = repository.objResponse
        failureMessage = repository.failureMessage
        objResponseSavePromotion = repository.objResponseSavePromotion
        objResponseGetPromotionStats = repository.objResponseGetPromotionStats
    }

    fun getEventPromote(eventId : String){
        repository.getEventPromote(eventId)
    }

    fun savePromotion(obj : SavePromotionRequestModel){
        repository.savePromotion(obj = obj)
    }

    fun getPromotionStats(eventId : String , start : String , end : String){
        repository.getPromotionStats(eventId = eventId , start = start , end = end)
    }
}