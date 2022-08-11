package com.hooleyapp.organizer.data.model.responsemodels.plaid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExchangeTokenResponseModel {

    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null

    @SerializedName("item_id")
    @Expose
    var itemId: String? = null

    @SerializedName("request_id")
    @Expose
    var requestId: String? = null
}