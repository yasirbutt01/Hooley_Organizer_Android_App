package com.hooleyapp.organizer.data.model.responsemodels.verifycode

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TwoWayFactorResponseModel {

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
        @SerializedName("id")
        @Expose
        var id: String = ""

        @SerializedName("is_verified")
        @Expose
        var isVerified: Boolean = false

        @SerializedName("msidn")
        @Expose
        var msidn: String = ""

    }
}