package com.jryingyang.accessappexercise.api

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("login")
    val login : String,

    @SerializedName("avatar_url")
    val avatar_url: String,

    @SerializedName("site_admin")
    val site_admin: Boolean
)
