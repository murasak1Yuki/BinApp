package ru.shvec.binapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BinInfoDto (

    @SerializedName("number")
    @Expose
    val number: CardNumberDto? = null,

    @SerializedName("scheme")
    @Expose
    val scheme: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("brand")
    @Expose
    val brand: String? = null,

    @SerializedName("prepaid")
    @Expose
    val prepaid: Boolean? = null,

    @SerializedName("country")
    @Expose
    val country: CountryDto? = null,

    @SerializedName("bank")
    @Expose
    val bank: BankDto? = null
)