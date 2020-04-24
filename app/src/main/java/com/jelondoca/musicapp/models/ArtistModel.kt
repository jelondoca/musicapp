package com.jelondoca.musicapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArtistModel (
    val id: Int,
    val name: String,
    val image: String
):Parcelable
