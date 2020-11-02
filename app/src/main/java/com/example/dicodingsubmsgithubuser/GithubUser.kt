package com.example.dicodingsubmsgithubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser (
    val name: String,
    val loc: String,
    val comp: String,
    val avatar: Int,
    val username: String,
    val followers: String,
    val following: String,
    val repo: String
) : Parcelable


