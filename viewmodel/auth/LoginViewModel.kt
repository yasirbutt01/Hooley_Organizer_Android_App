package com.hooleyapp.organizer.viewmodel.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.HooleyApp
import com.hooleyapp.organizer.data.model.requestmodel.ForgotPasswordRequestModel
import com.hooleyapp.organizer.data.model.requestmodel.LoginRequestModel
import com.hooleyapp.organizer.data.model.responsemodels.auth.LoginResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.repository.auth.LoginRepository
import com.hooleyapp.organizer.utilities.Constants
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class LoginViewModel(application : Application) : AndroidViewModel(application) {

    var repository = LoginRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<LoginResponseModel> = SingleLiveData()
    var objResponseGeneral: SingleLiveData<GeneralResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponse = repository.objResponse
        objResponseGeneral = repository.objResponseGeneral
    }

    fun login(email : String , password : String , authToken : String , isLoaderShown : Boolean) {
        repository.login(LoginRequestModel(email,password,authToken,
            HooleyApp.db.getString(Constants.DEVICE_ID)!!
        ),isLoaderShown)
    }


    fun forgetPassword(obj : ForgotPasswordRequestModel){
        repository.forgetPassword(obj = obj)
    }
}