package ru.shvec.binapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.shvec.binapp.data.repository.BinRepositoryImpl
import ru.shvec.binapp.domain.BinInfo
import ru.shvec.binapp.domain.GetBinInfoUseCase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = BinRepositoryImpl()
    private val getBinInfoUseCase = GetBinInfoUseCase(repository)

    private val _errorInputBin = MutableLiveData<Boolean>()
    val errorInputBin: LiveData<Boolean>
        get() = _errorInputBin


    suspend fun getBinInfo(bin: String?): BinInfo {
        val number = parseBin(bin)
        val fieldValid = validateInput(number)
        if (!fieldValid) {
            return BinInfo()
        }
        return getBinInfoUseCase.invoke(Integer.parseInt(bin.toString()))
    }

    private fun parseBin(bin: String?): Int {
        return try {
            bin?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(bin: Int): Boolean {
        var result = true
        if (bin <= 0 || bin.toString().length < 8) {
            _errorInputBin.value = true
            result = false
        }
        return result
    }
}