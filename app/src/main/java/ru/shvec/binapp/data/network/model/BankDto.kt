package ru.shvec.binapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BankDto(

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("phone")
    @Expose
    val phone: String? = null,

    @SerializedName("city")
    @Expose
    val city: String? = null
)
