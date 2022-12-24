package ru.shvec.binapp.domain

data class BinInfo(

    val number: CardNumber? = null,
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val country: Country? = null,
    val bank: Bank? = null
)
