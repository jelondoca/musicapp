package com.jelondoca.musicapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArtistModel (
    val id: Int,
    val name: String,
    val image: String,
    val genres: List<String>,
    val popularity: String,
    val createdAt: String,
    val updatedAt: String,
    val artist: Int
):Parcelable
