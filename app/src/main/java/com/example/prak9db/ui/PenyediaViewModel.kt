package com.example.prak9db.ui


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.prak9db.MahasiswaApplications
import com.example.prak9db.ui.home.viewmodel.HomeViewModel
import com.example.prak9db.ui.home.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(MahasiswaApp().container.mahasiswaRepository) }
        initializer { InsertViewModel(MahasiswaApp().container.mahasiswaRepository) }
    }
}

fun CreationExtras.MahasiswaApp(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)