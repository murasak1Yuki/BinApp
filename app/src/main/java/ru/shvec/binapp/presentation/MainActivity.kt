package ru.shvec.binapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.shvec.binapp.R
import ru.shvec.binapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.searchButton.setOnClickListener {
            val bin = binding.etBin.text.toString()
            val lonlatTemplate = application.resources.getString(R.string.lonlat_template)
            lifecycleScope.launch {
                val binInfo = viewModel.getBinInfo(bin)
                with(binding) {
                    tvSchemeValue.text = binInfo.scheme ?: EMPTY_SYMBOL
                    tvBrandValue.text = binInfo.brand ?: EMPTY_SYMBOL
                    tvLengthValue.text = binInfo.number?.length?.toString() ?: EMPTY_SYMBOL
                    tvLuhnValue.text = if (binInfo.number?.luhn == true) "Yes" else "No"
                    tvTypeValue.text = binInfo.type ?: EMPTY_SYMBOL
                    tvPrepaidValue.text = if (binInfo.prepaid == true) "Yes" else "No"
                    tvCountryValue.text = binInfo.country?.name ?: EMPTY_SYMBOL
                    tvLongLat.text = String.format(
                        lonlatTemplate,
                        binInfo.country?.latitude ?: EMPTY_SYMBOL,
                        binInfo.country?.longitude ?: EMPTY_SYMBOL
                    )
                    tvBankValue.text = binInfo.bank?.name ?: EMPTY_SYMBOL
                    tvBankUrl.text = binInfo.bank?.url ?: EMPTY_SYMBOL
                    tvBankPhone.text = binInfo.bank?.phone ?: EMPTY_SYMBOL
                }
            }
        }
        observeError()
    }

    private fun observeError() {
        viewModel.errorInputBin.observe(this) {
            val message = if (it) {
                getString(R.string.error_input_bin)
            } else {
                null
            }
            binding.tilBin.error = message
        }
    }

    companion object {
        private const val EMPTY_SYMBOL = "?"
    }
}