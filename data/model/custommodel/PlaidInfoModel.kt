package com.hooleyapp.organizer.data.model.custommodel

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class PlaidInfo(var account_id : String? ,var available_balance : String? ,var current_balance : String? ,var iso_currency_code : String? ,
                     var limit : String? ,var unofficial_currency_code : String? ,var mask : String? ,var name : String? ,
                     var official_name : String? ,var subtype : String? ,var type : String? ,var account_number : String? ,
                     var routing : String? ,var wire_routing : String? ,var institution : String? ,var branch : String? ,
                     var sort_code : String?) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(account_id)
        parcel.writeString(available_balance)
        parcel.writeString(current_balance)
        parcel.writeString(iso_currency_code)
        parcel.writeString(limit)
        parcel.writeString(unofficial_currency_code)
        parcel.writeString(mask)
        parcel.writeString(name)
        parcel.writeString(official_name)
        parcel.writeString(subtype)
        parcel.writeString(type)
        parcel.writeString(account_number)
        parcel.writeString(routing)
        parcel.writeString(wire_routing)
        parcel.writeString(institution)
        parcel.writeString(branch)
        parcel.writeString(sort_code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlaidInfo> {
        override fun createFromParcel(parcel: Parcel): PlaidInfo {
            return PlaidInfo(parcel)
        }

        override fun newArray(size: Int): Array<PlaidInfo?> {
            return arrayOfNulls(size)
        }
    }

}