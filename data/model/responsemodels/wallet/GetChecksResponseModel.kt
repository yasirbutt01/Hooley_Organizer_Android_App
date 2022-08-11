package com.hooleyapp.organizer.data.model.responsemodels.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetChecksResponseModel {

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
        @SerializedName("checks")
        @Expose
        var checksList: ArrayList<Checks>? = null
    }

    class Checks {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("nick_name")
        @Expose
        var nickName: String = ""

        @SerializedName("address")
        @Expose
        var address: String = ""

    }
}