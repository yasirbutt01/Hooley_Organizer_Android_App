package com.hooleyapp.organizer.data.model.responsemodels.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetAccountsResponseModel {

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
        var accountList: ArrayList<Accounts>? = null
    }

    class Accounts {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("number")
        @Expose
        var number: String = ""

        @SerializedName("status")
        @Expose
        var status: Int = 0

        @SerializedName("is_default")
        @Expose
        var isDefault: Boolean = false

    }
}