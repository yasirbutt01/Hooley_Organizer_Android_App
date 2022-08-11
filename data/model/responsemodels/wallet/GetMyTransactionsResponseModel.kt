package com.hooleyapp.organizer.data.model.responsemodels.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetMyTransactionsResponseModel {

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
        var transactionsList: ArrayList<Transaction>? = null
    }

    class Transaction {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("amount")
        @Expose
        var amount: Int = 0
        @SerializedName("date")
        @Expose
        var date: String? = null
        @SerializedName("status")
        @Expose
        var status: Int = 0
        @SerializedName("transaction_id")
        @Expose
        var transactionId: String? = null
        @SerializedName("account_number")
        @Expose
        var accountNumber: String = ""
        @SerializedName("bank")
        @Expose
        var bank: String? = null

        @SerializedName("feedback")
        @Expose
        var feedback: String? = null
    }
}