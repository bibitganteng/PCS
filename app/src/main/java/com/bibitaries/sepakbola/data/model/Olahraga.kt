package com.bibitaries.sepakbola.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Olahraga(
    val judul: String = "",
    val link: String = "",
    val poster: String = "",
    val tipe: String = "",
    val waktu: String = ""
) : Parcelable
