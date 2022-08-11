package com.hooleyapp.organizer.data.model.responsemodels.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetUserWalletResponseModel {

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
        @SerializedName("available_balance")
        @Expose
        var availableBalance: Double = 0.0
        @SerializedName("pending_balance")
        @Expose
        var pendingBalance: Double = 0.0
        @SerializedName("payment_method")
        @Expose
        var paymentMethod: Boolean = true

        @SerializedName("is_bankaccount")
        @Expose
        var is_bankaccount: Boolean = true

        @SerializedName("is_checkdeposed")
        @Expose
        var is_checkdeposed: Boolean = true

        @SerializedName("is_paypalaccount")
        @Expose
        var is_paypalaccount: Boolean = true

        @SerializedName("defult_account")
        @Expose
        var defultAccount: GetAccountsResponseModel.Accounts? = null

    }
}