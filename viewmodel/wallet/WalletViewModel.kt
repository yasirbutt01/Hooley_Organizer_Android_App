package com.hooleyapp.organizer.viewmodel.wallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hooleyapp.organizer.HooleyApp
import com.hooleyapp.organizer.data.model.requestmodel.*
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.wallet.*
import com.hooleyapp.organizer.data.remote.SingleEnqueueCall
import com.hooleyapp.organizer.data.repository.wallet.WalletRepository
import com.hooleyapp.organizer.utilities.Constants
import com.hooleyapp.organizer.utilities.helper.SingleLiveData

class WalletViewModel (application : Application) : AndroidViewModel(application)  {

    var repository = WalletRepository()
    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var objResponse: SingleLiveData<GetUserWalletResponseModel> = SingleLiveData()
    var objResponseCountry: SingleLiveData<GetCountryStateCitiesResponseModel> = SingleLiveData()
    var objResponseState: SingleLiveData<GetCountryStateCitiesResponseModel> = SingleLiveData()
    var objResponseCity: SingleLiveData<GetCountryStateCitiesResponseModel> = SingleLiveData()
    var objResponseBanks: SingleLiveData<GetBanksResponseModel> = SingleLiveData()
    var objResponseAddAccount: SingleLiveData<GeneralResponseModel> = SingleLiveData()
    var objResponseAccounts: SingleLiveData<GetAccountsResponseModel> = SingleLiveData()
    var objResponseDefaultOrDeleteAccount: SingleLiveData<Int> = SingleLiveData()
    var objResponseMyTransactions: SingleLiveData<GetMyTransactionsResponseModel> = SingleLiveData()
    var objResponseMyDetailTransactions: SingleLiveData<GetDetailTransactionResponseModel> = SingleLiveData()
    var objResponseChecks: SingleLiveData<GetChecksResponseModel> = SingleLiveData()
    var objResponsePayPalAccounts: SingleLiveData<GetPayPalAccountsResponseModel> = SingleLiveData()

    init {
        failureMessage = repository.failureMessage
        objResponse = repository.objResponse
        objResponseCountry = repository.objResponseCountry
        objResponseState = repository.objResponseState
        objResponseBanks = repository.objResponseBanks
        objResponseAddAccount = repository.objResponseAddAccount
        objResponseAccounts = repository.objResponseAccounts
        objResponseDefaultOrDeleteAccount = repository.objResponseDefaultOrDeleteAccount
        objResponseMyTransactions = repository.objResponseMyTransactions
        objResponseMyDetailTransactions = repository.objResponseMyDetailTransactions
        objResponseCity = repository.objResponseCity
        objResponseChecks = repository.objResponseChecks
        objResponsePayPalAccounts = repository.objResponsePayPalAccounts
    }

    fun getUserWallet(){
        repository.getUserWallet()
    }

    fun getCountryStateCity(area : String , countryId : Int , stateId : Int , isLoaderShown : Boolean){
        repository.getCountryStateCity(area,countryId,stateId,isLoaderShown)
    }

    fun getBanks(){
        repository.getBanks()
    }

    fun addAccount(addAccountRequestModel: AddAccountRequestModel){
        repository.addAccount(addAccountRequestModel)
    }

    fun addCheck(obj: AddCheckRequestModel){
        repository.addCheck(obj)
    }

    fun addPayPal(obj: AddPayPalRequestModel){
        repository.addPayPal(obj)
    }

    fun getAccounts(){
        repository.getAccounts()
    }


    fun makeDefault(obj: DefaultOrDeleteAccountRequestModel){
        repository.makeDefaultAccount(obj)
    }

    fun deleteAccount(obj: DefaultOrDeleteAccountRequestModel){
        repository.deleteAccount(obj)
    }

    fun deleteCheck(obj: DefaultOrDeleteAccountRequestModel){
        repository.deleteCheck(obj)
    }

    fun deletePayPal(obj: DefaultOrDeleteAccountRequestModel){
        repository.deletePayPal(obj)
    }

    fun getMyTransactions(){
        repository.getMyTransactions()
    }

    fun withdrawAmount(obj: WithdrawAmountRequestModel){
        repository.withdrawAmount(obj = obj)
    }

    fun requestTransactionCertificate(obj: RequestTransactionCertificateRequestModel){
        repository.requestTransactionCertificate(obj = obj)
    }

    fun getDetailTransaction(transactionId : String){
        repository.getDetailTransaction(transactionId)
    }

    fun getChecks(){
        repository.getChecks()
    }

    fun getPayPalAccounts(){
        repository.getPayPalAccounts()
    }
}