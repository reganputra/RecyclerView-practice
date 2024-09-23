package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
// menampilkan data Hero
data class Hero(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable

