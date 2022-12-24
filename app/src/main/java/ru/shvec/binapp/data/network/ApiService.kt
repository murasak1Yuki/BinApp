package ru.shvec.binapp.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import ru.shvec.binapp.data.network.model.BinInfoDto

interface ApiService {

    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: Int) : BinInfoDto
}