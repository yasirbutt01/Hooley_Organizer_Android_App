package com.hooleyapp.organizer.data.model.custommodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Zeeshan Irfan on 6/11/2018.
 */

class GetCityStateModel {





    @SerializedName("IsSuccessful")
    var success: Boolean = false

    @SerializedName("Exception")
    var exception: String? = null

    @SerializedName("statesWithCities")
    var statesWithCitiesList = ArrayList<StateCity>()

    class StateCity() : Parcelable {

        @field:SerializedName("id")
        lateinit var id: String
        @field:SerializedName("name")
        lateinit var name: String
        lateinit var city: ArrayList<City>
        @SerializedName("cities")
        var citiesList = ArrayList<City>()

        var isChecked: Boolean = false
        var multiSelect: Boolean = false
        var selectAll: Boolean = false
        var isExpand : Boolean = false

        constructor(parcel: Parcel) : this() {
            id = parcel.readString()
            name = parcel.readString()
            isChecked = parcel.readByte() != 0.toByte()
            multiSelect = parcel.readByte() != 0.toByte()
            selectAll = parcel.readByte() != 0.toByte()
        }

        constructor(id: String, name: String, citiesList: ArrayList<City>) : this() {
            this.id = id
            this.name = name
            this.citiesList = citiesList
            city = citiesList
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(id)
            parcel.writeString(name)
            parcel.writeByte(if (isChecked) 1 else 0)
            parcel.writeByte(if (multiSelect) 1 else 0)
            parcel.writeByte(if (selectAll) 1 else 0)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<StateCity> {
            override fun createFromParcel(parcel: Parcel): StateCity {
                return StateCity(parcel)
            }

            override fun newArray(size: Int): Array<StateCity?> {
                return arrayOfNulls(size)
            }
        }

    }

    class City(@field:SerializedName("id")
               var id: String, @field:SerializedName("name")
               var name: String, var isChecked: Boolean)


}
