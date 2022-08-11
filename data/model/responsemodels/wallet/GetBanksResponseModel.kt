package com.hooleyapp.organizer.data.model.responsemodels.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetBanksResponseModel {

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
        @SerializedName("banks")
        @Expose
        var banks: ArrayList<Bank>? = null
    }

    class Bank {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("name")
        @Expose
        var name: String? = null

    }
}