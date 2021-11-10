package com.tiyas.mygithubapp


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name : String,
    var username : String,
    var photo : Int ,
    var followers : String? = null  ,
    var following : String? = null ,
    var company : String? = null ,
    var repository : String? = null ,
    var location : String? = null
) : Parcelable

