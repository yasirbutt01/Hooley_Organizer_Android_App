package com.hooleyapp.organizer.data.model.responsemodels.events

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetEventsListResponseModel {

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
        @SerializedName("event_listings")
        @Expose
        var eventListing: ArrayList<EventListing>? = null
    }


    class EventListing {
        @SerializedName("id")
        @Expose
        var id: String? = null
        @SerializedName("event_name")
        @Expose
        var eventName: String? = null
        @SerializedName("image_url")
        @Expose
        var imageUrl: String = ""
        @SerializedName("tickets_count")
        @Expose
        var ticketsCount: Int = 0
        @SerializedName("event_type")
        @Expose
        var eventType: Int = 1

        @SerializedName("created_date")
        @Expose
        var createdDate: String = ""

        @SerializedName("end_date")
        @Expose
        var endDate: String = ""

        @SerializedName("promoted")
        @Expose
        var promoted: Boolean = false


        @SerializedName("ppv")
        @Expose
        var ppv: Boolean = false

        @SerializedName("start_date")
        @Expose
        var startDate: String = ""
    }
}