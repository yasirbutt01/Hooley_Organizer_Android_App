package com.hooleyapp.organizer.data.model.responsemodels.community

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetMediaReportsDetailResponseModel {

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

        @SerializedName("caption")
        @Expose
        var caption: String? = null


        @SerializedName("media")
        @Expose
        var media: ArrayList<Media>? = null

        @SerializedName("repots")
        @Expose
        var repots: ArrayList<Report>? = null
    }

    class Report {

        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("count")
        @Expose
        var count: Int = 0

    }

    class Media {

        @SerializedName("id")
        @Expose
        var id: String? = null

        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("thumbnail_url")
        @Expose
        var thumbnailUrl: String? = null

        @SerializedName("is_video")
        @Expose
        var isVideo: Boolean = false

    }
}