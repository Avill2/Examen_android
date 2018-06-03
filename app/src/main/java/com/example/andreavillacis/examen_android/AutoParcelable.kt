package com.example.andreavillacis.examen_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

class AutoParcelable(var chasis:Int,
                     var nombreMarca:String,
                     var colorUno:String,
                     var colorDos:String,
                     var nombreModelo:String,
                     var anio:Int,
                     var idConductor:Int): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(chasis)
        parcel.writeString(nombreMarca)
        parcel.writeString(colorUno)
        parcel.writeString(colorDos)
        parcel.writeString(nombreModelo)
        parcel.writeInt(anio)
        parcel.writeInt(idConductor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AutoParcelable> {
        override fun createFromParcel(parcel: Parcel): AutoParcelable {
            return AutoParcelable(parcel)
        }

        override fun newArray(size: Int): Array<AutoParcelable?> {
            return arrayOfNulls(size)
        }
    }

}
