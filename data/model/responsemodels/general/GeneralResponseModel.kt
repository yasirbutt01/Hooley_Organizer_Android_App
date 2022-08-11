package com.hooleyapp.organizer.data.model.responsemodels.general

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeneralResponseModel {
    @SerializedName("status")
    @Expose
    var status: Boolean = false
    @SerializedName("message")
    @Expose
    var message: String? = null
}
