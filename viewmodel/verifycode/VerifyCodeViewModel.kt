package com.hooleyapp.organizer.viewmodel.verifycode

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.data.model.requestmodel.VerifyPhoneCodeRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.verifycode.TwoWayFactorResponseModel
import com.hooleyapp.organizer.data.repository.verifycode.VerifyCodeRepository
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class VerifyCodeViewModel(application : Application) : AndroidViewModel(application) {

    var repository = VerifyCodeRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponseTwoFactor: SingleLiveData<TwoWayFactorResponseModel> = SingleLiveData()
    var objResponseGeneral: SingleLiveData<GeneralResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponseTwoFactor = repository.objResponseTwoFactor
        objResponseGeneral = repository.objResponseGeneral
    }


    fun twoWayFactor(type : Int){
        repository.twoWayFactor(type)
    }

    fun verifyCode(obj : VerifyPhoneCodeRequestModel){
        repository.verifyCode(obj)
    }

}