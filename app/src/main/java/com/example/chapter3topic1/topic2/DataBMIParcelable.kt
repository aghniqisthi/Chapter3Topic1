package com.example.chapter3topic1.topic2

import android.os.Parcel
import android.os.Parcelable

data class DataBMIParcelable(val umur: String, val tb:String, val bb:String, val bmi:String, val kategori:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(umur)
        parcel.writeString(tb)
        parcel.writeString(bb)
        parcel.writeString(bmi)
        parcel.writeString(kategori)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataBMIParcelable> {
        override fun createFromParcel(parcel: Parcel): DataBMIParcelable {
            return DataBMIParcelable(parcel)
        }

        override fun newArray(size: Int): Array<DataBMIParcelable?> {
            return arrayOfNulls(size)
        }
    }
}
