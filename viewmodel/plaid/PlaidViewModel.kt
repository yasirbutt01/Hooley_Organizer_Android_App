package com.hooleyapp.organizer.viewmodel.plaid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.AuthRequestModel
import com.hooleyapp.organizer.data.model.requestmodel.ExchangeTokenRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.plaid.AuthResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.plaid.ExchangeTokenResponseModel
import com.hooleyapp.organizer.data.repository.plaid.PlaidRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class PlaidViewModel(application: Application) : AndroidViewModel(application) {

    var repository = PlaidRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponseAuth: SingleLiveData<AuthResponseModel> = SingleLiveData()
    var objResponseExchangeToken: SingleLiveData<ExchangeTokenResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponseAuth = repository.objResponseAuth
        objResponseExchangeToken = repository.objResponseExchangeToken
    }

    fun auth(obj: AuthRequestModel) {
        repository.auth(obj)
    }

    fun exchangeToken(obj: ExchangeTokenRequestModel) {
        repository.exchangeToken(obj)
    }
}