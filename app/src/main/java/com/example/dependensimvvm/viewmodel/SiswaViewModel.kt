package com.example.dependensimvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dependensimvvm.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {
    private val _statusUI = MutableStateFlow(DataSiswa())
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun setSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                alamat = ls[2]
            )
        }
    }
}
