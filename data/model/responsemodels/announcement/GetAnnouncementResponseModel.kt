package com.hooleyapp.organizer.data.model.responsemodels.announcement

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetAnnouncementResponseModel {

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
        @SerializedName("annoucements")
        @Expose
        var annoucements: ArrayList<Annoucements>? = null
    }

    class Annoucements {
        @SerializedName("id")
        @Expose
        var id: Int = 0

        @SerializedName("type")
        @Expose
        var type: Int = 0

        @SerializedName("posted_date")
        @Expose
        var postedDate: String? = null

        @SerializedName("image_url")
        @Expose
        var imageUrl: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("old_start_date")
        @Expose
        var oldStartDate: String? = null

        @SerializedName("old_end_date")
        @Expose
        var oldEndDate: String? = null

        @SerializedName("new_start_date")
        @Expose
        var newStartDate: String? = null

        @SerializedName("new_end_date")
        @Expose
        var newEndDate: String? = null

        @SerializedName("old_location")
        @Expose
        var oldLocation: String? = null

        @SerializedName("new_location")
        @Expose
        var newLocation: String? = null

        @SerializedName("broadcast_all")
        @Expose
        var broadcastAll: Boolean = false

        @SerializedName("broadcast_here_now")
        @Expose
        var broadcastHereNow: Boolean = false

    }


}