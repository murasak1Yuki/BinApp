package ru.shvec.binapp.domain


interface BinRepository {

    suspend fun getBinInfo(bin: Int): BinInfo
}