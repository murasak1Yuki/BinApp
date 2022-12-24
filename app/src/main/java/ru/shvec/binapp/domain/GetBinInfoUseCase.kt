package ru.shvec.binapp.domain

class GetBinInfoUseCase(
    private val repository: BinRepository
) {
    suspend operator fun invoke(bin: Int) : BinInfo = repository.getBinInfo(bin)
}