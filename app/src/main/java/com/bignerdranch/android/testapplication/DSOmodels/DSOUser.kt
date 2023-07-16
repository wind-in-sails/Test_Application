package com.bignerdranch.android.testapplication.DSOmodels

import com.google.gson.annotations.SerializedName

data class DSOUser(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?
)
