package com.hooleyapp.organizer.data.model.responsemodels.events

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetTicketSalesResponseModel {

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
        @SerializedName("general")
        @Expose
        var generalList: ArrayList<General>? = null

        @SerializedName("ppv")
        @Expose
        var ppvList: ArrayList<Ppv>? = null

        @SerializedName("charity")
        @Expose
        var charity: Charity? = null


        @SerializedName("event_info")
        @Expose
        var eventInfo: GetEventsListResponseModel.EventListing? = null
    }


    class General {
        @SerializedName("category_id")
        @Expose
        var categoryId: Int = 0

        @SerializedName("ticket_category")
        @Expose
        var ticketCategory: String? = null
        @SerializedName("price")
        @Expose
        var price: Int = 0
        @SerializedName("total")
        @Expose
        var total: Int = 0
        @SerializedName("sold")
        @Expose
        var sold: Int = 0
        @SerializedName("revenue")
        @Expose
        var revenue: Double = 0.0

        @SerializedName("fee")
        @Expose
        var fee: Double = 0.0

        @SerializedName("totalRevenue")
        @Expose
        var totalRevenue: Double = 0.0
    }

    class Ppv {
        @SerializedName("price")
        @Expose
        var price: Int = 0
        @SerializedName("sold")
        @Expose
        var sold: Int = 0
        @SerializedName("revenue")
        @Expose
        var revenue: Double = 0.0

        @SerializedName("fee")
        @Expose
        var fee: Double = 0.0

        @SerializedName("totalRevenue")
        @Expose
        var totalRevenue: Double = 0.0
    }

    class Charity {
        @SerializedName("charity_target")
        @Expose
        var charityTarget: Double = 0.0
        @SerializedName("remote_donations")
        @Expose
        var remoteDonations: Double = 0.0

        @SerializedName("fee")
        @Expose
        var fee: Double = 0.0

        @SerializedName("totalRevenue")
        @Expose
        var totalRevenue: Double = 0.0
    }

}