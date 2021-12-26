package com.example.myapplication.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseResponse<T> {
    @SerializedName("data")
    @Expose
    var data: T? = null
}