package com.example.prak9db.ui.home.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.prak9db.repository.MahasiswaRepository


class InsertViewModel (private mhs: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set


}



data class InsertUiState(
    val insertUiEvent:InsertUiEvent = InsertUiEvent()
)
