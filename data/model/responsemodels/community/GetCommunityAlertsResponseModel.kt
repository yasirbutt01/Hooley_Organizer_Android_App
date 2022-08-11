package com.hooleyapp.organizer.data.model.responsemodels.community

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetCommunityAlertsResponseModel {

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
        @SerializedName("listing")
        @Expose
        var eventList: ArrayList<EventList>? = null
    }

    class EventList {
        @SerializedName("id")
        @Expose
        var id: String? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("url")
        @Expose
        var url: String = ""
        @SerializedName("count")
        @Expose
        var count: Int = 0
        @SerializedName("date")
        @Expose
        var date: String = ""

    }
}