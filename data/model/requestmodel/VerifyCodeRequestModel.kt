package com.hooleyapp.organizer.data.model.requestmodel


data class TwoWayFactorRequestModel(val type : Int)

data class VerifyPhoneCodeRequestModel(val id : String , val code : String , val type: Int)