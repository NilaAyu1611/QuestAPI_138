package com.example.prak9db.ui.home.viewmodel

import android.provider.ContactsContract.Intents.Insert
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.prak9db.model.Mahasiswa
import com.example.prak9db.repository.MahasiswaRepository


class InsertViewModel (private mhs: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set


}



data class InsertUiState(
    val insertUiEvent:InsertUiEvent = InsertUiEvent()
)


data class InsertUiEvent(
    val nim: String = "",
    val nama: String = "",
    val alamat: String = "",
    val jenisKelamin: String = "",
    val kelas: String = "",
    val angkatan: String = "",
)

fun InsertUiEvent.toMhs(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)

fun Mahasiswa.toUiStateMhs():InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)
