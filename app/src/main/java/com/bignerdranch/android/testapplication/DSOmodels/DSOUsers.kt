package com.bignerdranch.android.testapplication.DSOmodels

import com.google.gson.annotations.SerializedName

data class DSOUsers(
    @SerializedName("users")
    val users: List<DSOUser>?
)
