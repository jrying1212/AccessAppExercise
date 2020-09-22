package com.jryingyang.accessappexercise.api

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("avatar_url")
    val avatar_url: String,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("bio")
    val bio: String? = null,

    @SerializedName("login")
    val login: String,

    @SerializedName("site_admin")
    val site_admin: Boolean,

    @SerializedName("location")
    val location: String? = null,

    @SerializedName("blog")
    val blog: String? = null
)