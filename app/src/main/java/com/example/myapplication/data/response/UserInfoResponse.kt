package com.example.myapplication.data.response

import com.example.myapplication.data.entities.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserInfoResponse {
        @SerializedName("data")
        @Expose
        var data: User? = null
}