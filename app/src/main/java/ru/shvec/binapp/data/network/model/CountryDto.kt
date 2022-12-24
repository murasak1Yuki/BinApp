package ru.shvec.binapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryDto(

    @SerializedName("numeric")
    @Expose
    val numeric: String? = null,

    @SerializedName("alpha2")
    @Expose
    val alpha2: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("emoji")
    @Expose
    val emoji: String? = null,

    @SerializedName("currency")
    @Expose
    val currency: String? = null,

    @SerializedName("latitude")
    @Expose
    val latitude: Int? = null,

    @SerializedName("longitude")
    @Expose
    val longitude: Int? = null
)
