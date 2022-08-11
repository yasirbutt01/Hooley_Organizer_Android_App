package com.hooleyapp.organizer.data.model.responsemodels.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetCountryStateCitiesResponseModel {

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
        @SerializedName("area_list")
        @Expose
        var areaList: ArrayList<Area>? = null
    }

    class Area {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("name")
        @Expose
        var name: String? = null

        constructor(id: Int, name: String?) {
            this.id = id
            this.name = name
        }
    }
}