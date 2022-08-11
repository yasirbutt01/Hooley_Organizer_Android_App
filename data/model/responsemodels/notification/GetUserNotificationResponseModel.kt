package com.hooleyapp.organizer.data.model.responsemodels.notification

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetUserNotificationResponseModel {

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
        @SerializedName("notifications")
        @Expose
        var notificationsList: ArrayList<Notification>? = null
    }

    class Notification {
        @SerializedName("event_id")
        @Expose
        var eventId: Int = 0

        @SerializedName("transaction_id")
        @Expose
        var transactionId: Int = 0

        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("text")
        @Expose
        var text: String? = null

        @SerializedName("date")
        @Expose
        var date: String? = null

        @SerializedName("type")
        @Expose
        var type: String? = null

        @SerializedName("status")
        @Expose
        var status: Int = 0

    }
}