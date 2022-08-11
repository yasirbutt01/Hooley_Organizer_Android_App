package com.hooleyapp.organizer.data.model.responsemodels.promotion

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetPromotionStatsResponseModel {

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
        @SerializedName("views_by_dates")
        @Expose
        var viewsByDates: ArrayList<ViewsByDates>? = null

        @SerializedName("gender_stats")
        @Expose
        var genderStats: ArrayList<GenderStats>? = null

        @SerializedName("states")
        @Expose
        var states: ArrayList<States>? = null

        @SerializedName("agegroup_stats")
        @Expose
        var ageGroupStats: ArrayList<AgeGroupStats>? = null

    }

    class ViewsByDates {
        @SerializedName("date")
        @Expose
        var date: String? = null
        @SerializedName("count")
        @Expose
        var count: Int = 0
    }

    class GenderStats {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("value")
        @Expose
        var value: Float = 0F
    }

    class States {
        @SerializedName("id")
        @Expose
        var id: Int = 0

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("count")
        @Expose
        var count: Int = 0
    }


    class AgeGroupStats {
        @SerializedName("id")
        @Expose
        var id: Int = 0

        @SerializedName("male")
        @Expose
        var male: Int = 0

        @SerializedName("female")
        @Expose
        var female: Int = 0

        @SerializedName("trans")
        @Expose
        var trans: Int = 0

    }
}