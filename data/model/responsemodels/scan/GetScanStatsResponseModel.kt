package com.hooleyapp.organizer.data.model.responsemodels.scan

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetScanStatsResponseModel {

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
        @SerializedName("scan_stats")
        @Expose
        var scanStats: ArrayList<ScanStats>? = null
    }

    class ScanStats {

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("sold")
        @Expose
        var sold: Int = 0

        @SerializedName("scanned")
        @Expose
        var scanned: Int = 0

        @SerializedName("unscanned")
        @Expose
        var unscanned: Int = 0


    }
}