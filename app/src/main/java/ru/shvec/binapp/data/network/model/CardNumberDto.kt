package ru.shvec.binapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CardNumberDto(

    @SerializedName("length")
    @Expose
    val length: Int? = null,

    @SerializedName("luhn")
    @Expose
    val luhn: Boolean? = null
)
