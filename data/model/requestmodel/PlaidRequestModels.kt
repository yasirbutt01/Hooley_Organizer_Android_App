package com.hooleyapp.organizer.data.model.requestmodel

data class ExchangeTokenRequestModel(val client_id : String , val secret : String , val public_token : String)

data class AuthRequestModel(val client_id : String , val secret : String , val access_token : String)