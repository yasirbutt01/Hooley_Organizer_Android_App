package com.hooleyapp.organizer.data.model.responsemodels.events

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetTotalRevenueTrasactionResponseModel {

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
        @SerializedName("transactions")
        @Expose
        var transactions: ArrayList<Transactions>? = null
    }


    class Transactions {
        @SerializedName("amount")
        @Expose
        var amount: Double = 0.0
        @SerializedName("category")
        @Expose
        var category: String? = null
        @SerializedName("transaction_id")
        @Expose
        var transactionId: String? = null
        @SerializedName("date")
        @Expose
        var date: String = ""

        @SerializedName("refund")
        @Expose
        var refund: Boolean = false

        @SerializedName("fee")
        @Expose
        var fee: Double = 0.0

        @SerializedName("payout")
        @Expose
        var payout: Double = 0.0


    }
}