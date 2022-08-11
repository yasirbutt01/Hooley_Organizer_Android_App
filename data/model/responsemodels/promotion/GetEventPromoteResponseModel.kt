package com.hooleyapp.organizer.data.model.responsemodels.promotion

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetEventPromoteResponseModel {

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
        @SerializedName("min_max_range")
        @Expose
        var minMaxRange: MinMaxRange? = null


        @SerializedName("cards")
        @Expose
        var cardList: ArrayList<Card>? = null
    }

    class MinMaxRange {
        @SerializedName("min_amount")
        @Expose
        var minAmount: Int = 0

        @SerializedName("max_amount")
        @Expose
        var maxAmount: Int = 0

    }

    class Card {

        @SerializedName("cardId")
        @Expose
        var cardId: String? = null

        @SerializedName("last4")
        @Expose
        var last4: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("exp_month")
        @Expose
        var expMonth: String? = null

        @SerializedName("exp_year")
        @Expose
        var expYear: String? = null

        @SerializedName("brand")
        @Expose
        var brand: String? = null

    }
}