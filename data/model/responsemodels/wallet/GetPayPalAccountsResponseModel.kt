package com.hooleyapp.organizer.data.model.responsemodels.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetPayPalAccountsResponseModel {

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
        @SerializedName("accounts")
        @Expose
        var accountsList: ArrayList<Accounts>? = null
    }

    class Accounts {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("full_name")
        @Expose
        var fullName: String? = null

        @SerializedName("email")
        @Expose
        var email: String = ""

    }
}