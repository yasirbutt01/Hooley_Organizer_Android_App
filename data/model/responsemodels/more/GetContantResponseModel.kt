package com.hooleyapp.organizer.data.model.responsemodels.more

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetContantResponseModel {

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
        @SerializedName("contant")
        @Expose
        var contant: String? = null
    }
}