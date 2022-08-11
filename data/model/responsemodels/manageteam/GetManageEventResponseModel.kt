package com.hooleyapp.organizer.data.model.responsemodels.manageteam

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetManageEventResponseModel {

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
        @SerializedName("user_list")
        @Expose
        var userList: ArrayList<User>? = null
    }

    class User() : Parcelable{
        override fun writeToParcel(p0: Parcel?, p1: Int) {
            p0!!.writeInt(userId)
            p0!!.writeString(url)
            p0!!.writeString(name)
            p0!!.writeString(country)
            p0!!.writeString(state)
            p0!!.writeString(city)
        }

        override fun describeContents(): Int {
            return 0
        }

        @SerializedName("user_id")
        @Expose
        var userId: Int = 0

        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("country")
        @Expose
        var country: String? = null

        @SerializedName("state")
        @Expose
        var state: String? = null

        @SerializedName("city")
        @Expose
        var city: String? = null

        constructor(parcel: Parcel) : this() {
            userId = parcel.readInt()
            url = parcel.readString()
            name = parcel.readString()
            country = parcel.readString()
            state = parcel.readString()
            city = parcel.readString()
        }

        companion object CREATOR : Parcelable.Creator<User> {
            override fun createFromParcel(parcel: Parcel): User {
                return User(parcel)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }

    }
}