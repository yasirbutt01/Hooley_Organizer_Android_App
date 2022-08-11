package com.hooleyapp.organizer.data.model.responsemodels.dashboard

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hooleyapp.organizer.data.model.responsemodels.events.GetTicketRevenueResponseModel

class GetDashboardResponseModel {

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
        @SerializedName("ticket_details")
        @Expose
        var ticketDetails: ArrayList<GetTicketRevenueResponseModel.TicketDetails>? = arrayListOf()

        @SerializedName("available_balance")
        @Expose
        var availableBalance: Double = 0.0

        @SerializedName("total_revenue")
        @Expose
        var totalRevenue: Double = 0.0

        var currentDate : String = ""
    }
}