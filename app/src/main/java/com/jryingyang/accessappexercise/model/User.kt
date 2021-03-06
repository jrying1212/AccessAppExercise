package com.jryingyang.accessappexercise.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatar_url: String,

    @SerializedName("site_admin")
    val site_admin: Boolean,

    @SerializedName("id")
    var id: Int
)
