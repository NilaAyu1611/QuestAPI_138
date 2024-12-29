package com.example.prak9db.ui.home.viewmodel

import com.example.prak9db.model.Mahasiswa

sealed class HomeUiState{
    data class Succes(val mahasiswa: List<Mahasiswa>):HomeUiState()
    object Error: HomeUiState()
    object Loading:HomeUiState()
}

