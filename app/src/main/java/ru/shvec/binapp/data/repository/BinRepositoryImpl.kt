package ru.shvec.binapp.data.repository

import ru.shvec.binapp.data.mapper.BinMapper
import ru.shvec.binapp.data.network.ApiFactory
import ru.shvec.binapp.domain.BinInfo
import ru.shvec.binapp.domain.BinRepository

class BinRepositoryImpl : BinRepository {

    private val apiService = ApiFactory.apiService

    private val mapper = BinMapper()

    override suspend fun getBinInfo(bin: Int): BinInfo {
        return try {
            val binInfoDto = apiService.getBinInfo(bin)
            mapper.mapDtoToEntity(binInfoDto)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}