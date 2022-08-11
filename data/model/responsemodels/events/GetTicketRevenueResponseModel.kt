package com.hooleyapp.organizer.data.model.responsemodels.events

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hooleyapp.organizer.data.model.responsemodels.promotion.GetPromotionStatsResponseModel

class GetTicketRevenueResponseModel {

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
        var ticketDetails: ArrayList<TicketDetails>? = null

        @SerializedName("gender_stats")
        @Expose
        var genderStats: ArrayList<GenderStats>? = null

        @SerializedName("agegroup_stats")
        @Expose
        var agegroupStats: ArrayList<GetPromotionStatsResponseModel.AgeGroupStats>? = null

        @SerializedName("refund_count")
        @Expose
        var refundCount: Int = 0
    }

    class TicketDetails {
        @SerializedName("date")
        @Expose
        var date: String? = null
        @SerializedName("amount")
        @Expose
        var amount: Float = 0f
    }

    class GenderStats {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("value")
        @Expose
        var value: Float = 0F


        constructor(id: Int, value: Float) {
            this.id = id
            this.value = value
        }
    }

}