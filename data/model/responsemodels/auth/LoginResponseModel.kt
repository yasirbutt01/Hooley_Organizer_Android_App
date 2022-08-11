package com.hooleyapp.organizer.data.model.responsemodels.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponseModel {
    @SerializedName("status")
    @Expose
    var status: Boolean = false
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("data")
    @Expose
    var data: Data? = null

    class Data {
        @SerializedName("auth_token")
        @Expose
        var authToken: String? = null

        @SerializedName("user")
        @Expose
        var user: User? = null

    }

    class User {
        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

    }
}