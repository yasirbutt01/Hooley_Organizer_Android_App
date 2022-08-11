package com.hooleyapp.organizer.data.model.requestmodel

import com.hooleyapp.organizer.data.model.custommodel.PlaidInfo

data class AddAccountRequestModel(
    val id: Int,
    val country_id: Int,
    val company: Boolean,
    val first_name: String,
    val last_name: String,
    val address1: String,
    val address2: String,
    val state_id: Int,
    val city: String,
    val saving: Boolean,
    val bank_id: Int,
    val routing_number: String,
    val account_number: String,
    val account_title: String,
    val plaid_account : PlaidInfo

)

data class DefaultOrDeleteAccountRequestModel(val id: Int)

data class WithdrawAmountRequestModel(val account_id: Int, val payment_method : Int , val amount: Int)

data class RequestTransactionCertificateRequestModel(val transaction_id: Int)

data class AddCheckRequestModel(
    val country_id: Int,
    val address1: String,
    val address2: String,
    val state_id: Int,
    val city_id: Int,
    val post_code: String,
    val name: String,
    val AccountNickname: String
)

data class AddPayPalRequestModel(
    val first_name: String,
    val last_name: String,
    val email: String
)