package com.hooleyapp.organizer.data.model.responsemodels.events

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetEventDetailsResponseModel {

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
        @SerializedName("promotion")
        @Expose
        var promotion: Promotion? = null

        @SerializedName("engagement_counts")
        @Expose
        var engagementCounts: EngagementCounts? = null

        @SerializedName("scan")
        @Expose
        var scan: Scan? = null

        @SerializedName("tickets")
        @Expose
        var tickets: Tickets? = null

        @SerializedName("annoucment")
        @Expose
        var annoucment: Int = 0

        @SerializedName("manage")
        @Expose
        var manage: Int = 0
    }

    class Promotion {
        @SerializedName("start_time")
        @Expose
        var start_time: String? = null

        @SerializedName("end_time")
        @Expose
        var end_time: String? = null

        @SerializedName("count")
        @Expose
        var count: Int = 0
    }

    class EngagementCounts {
        @SerializedName("likes")
        @Expose
        var likes: Int = 0

        @SerializedName("attend")
        @Expose
        var attend: Int = 0

        @SerializedName("follow")
        @Expose
        var follow: Int = 0

        @SerializedName("share")
        @Expose
        var share: Int = 0

        @SerializedName("invite")
        @Expose
        var invite: Int = 0

        @SerializedName("interest")
        @Expose
        var interest: Int = 0

    }


    class Scan {
        @SerializedName("scanned")
        @Expose
        var scanned: Int = 0

        @SerializedName("unscanned")
        @Expose
        var unscanned: Int = 0
    }

    class Tickets {
        @SerializedName("total")
        @Expose
        var total: Int = 0

        @SerializedName("sold")
        @Expose
        var sold: Int = 0

        @SerializedName("revenue")
        @Expose
        var revenue: Double = 0.0
    }
}