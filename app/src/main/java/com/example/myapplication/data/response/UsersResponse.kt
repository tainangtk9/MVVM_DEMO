package com.example.myapplication.data.response

import com.example.myapplication.data.entities.User
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class UsersResponse {
    @SerializedName("data")
    @Expose
    var data: List<User>? = null

    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("per_page")
    @Expose
    var perPage: Int? = null

    @SerializedName("total")
    @Expose
    var total: Int? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
}