package com.hooleyapp.organizer.viewmodel.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.responsemodels.events.*
import com.hooleyapp.organizer.data.repository.events.EventsRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class EventsViewModel(application : Application) : AndroidViewModel(application) {

    var repository = EventsRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetEventsListResponseModel> = SingleLiveData()
    var objResponseTicketSales: SingleLiveData<GetTicketSalesResponseModel> = SingleLiveData()
    var objResponseTotalRevenue: SingleLiveData<GetTotalRevenueTrasactionResponseModel> = SingleLiveData()
    var objResponseTicketRevenueDetail: SingleLiveData<GetTicketRevenueResponseModel> = SingleLiveData()
    var objResponseEventDetailsResponse: SingleLiveData<GetEventDetailsResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponse = repository.objResponse
        objResponseTicketSales = repository.objResponseTicketSales
        objResponseTotalRevenue = repository.objResponseTotalRevenue
        objResponseTicketRevenueDetail = repository.objResponseTicketRevenueDetail
        objResponseEventDetailsResponse = repository.objResponseEventDetailsResponse
    }

    fun getEventList(isPast : Boolean ,skip : Int , take : Int, isLoaderShown : Boolean) {
        repository.getEventList(isPast,skip,take,isLoaderShown)
    }

    fun getTicketSales(eventId : String, isLoaderShown : Boolean) {
        repository.getTicketSales(eventId,isLoaderShown)
    }

    fun getTotalRevenue(eventId : String, isLoaderShown : Boolean) {
        repository.getTotalReveue(eventId,isLoaderShown)
    }

    fun getTicketDetailByCategoryId(eventId : String , categoryId : String , start : String , end : String, isLoaderShown : Boolean){
        repository.getTicketDetailByCatedotyId(eventId, categoryId ,start ,end ,isLoaderShown)
    }

    fun getEventDetails(eventId : String) {
        repository.getEventDetails(eventId)
    }
}