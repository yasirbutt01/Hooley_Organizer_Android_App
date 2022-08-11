package com.hooleyapp.organizer.data.model.responsemodels.plaid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthResponseModel {

    @SerializedName("accounts")
    @Expose
    var accounts: ArrayList<Account>? = null

    @SerializedName("numbers")
    @Expose
    var numbers: Numbers? = null

    @SerializedName("request_id")
    @Expose
    var requestId: String? = null


    class Account {
        @SerializedName("account_id")
        @Expose
        var accountId: String = ""

        @SerializedName("mask")
        @Expose
        var mask: String = ""

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("official_name")
        @Expose
        var officialName: String? = null

        @SerializedName("subtype")
        @Expose
        var subtype: String? = null

        @SerializedName("type")
        @Expose
        var type: String? = null


        @SerializedName("balances")
        @Expose
        var balances: Balance? = null


        class Balance {
            @SerializedName("available")
            @Expose
            var available: String = ""

            @SerializedName("current")
            @Expose
            var current: String = ""

            @SerializedName("iso_currency_code")
            @Expose
            var isoCurrencyCode: String? = null

            @SerializedName("limit")
            @Expose
            var limit: String? = null

            @SerializedName("unofficial_currency_code")
            @Expose
            var unofficialCurrencyCode: String? = null
        }
    }

    class Numbers {
        @SerializedName("ach")
        @Expose
        var ach: ArrayList<Ach>? = null

        @SerializedName("bacs")
        @Expose
        var bacs: ArrayList<Bacs>? = null

        @SerializedName("eft")
        @Expose
        var eft: ArrayList<Eft>? = null

        class Ach {
            @SerializedName("account")
            @Expose
            var account: String = ""

            @SerializedName("account_id")
            @Expose
            var accountId: String = ""

            @SerializedName("routing")
            @Expose
            var routing: String? = null

            @SerializedName("wire_routing")
            @Expose
            var wireRouting: String? = null
        }

        class Bacs {
            @SerializedName("account")
            @Expose
            var account: String = ""

            @SerializedName("account_id")
            @Expose
            var accountId: String = ""

            @SerializedName("sort_code")
            @Expose
            var sortCode: String? = null
        }

        class Eft {
            @SerializedName("account")
            @Expose
            var account: String = ""

            @SerializedName("account_id")
            @Expose
            var accountId: String = ""

            @SerializedName("institution")
            @Expose
            var institution: String? = null

            @SerializedName("branch")
            @Expose
            var branch: String? = null
        }
    }
}