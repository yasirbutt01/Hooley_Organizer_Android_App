package com.hooleyapp.organizer.data.model.requestmodel

data class LoginRequestModel(val email: String, val password: String, val auth_token: String, val device_token : String)

data class ForgotPasswordRequestModel(val email: String)