package com.example.prak9db.ui.home.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prak9db.model.Mahasiswa
import com.example.prak9db.repository.MahasiswaRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed class HomeUiState{
    data class Succes(val mahasiswa: List<Mahasiswa>):HomeUiState()
    object Error: HomeUiState()
    object Loading:HomeUiState()
}

class HomeViewModel (private val mhs: MahasiswaRepository): ViewModel(){
    var mhsUIState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }


    fun getMhs(){
        viewModelScope.launch{
            mhsUIState = HomeUiState.Loading
            mhsUIState=try{
                HomeUiState.Succes(mhs.getMahasiswa())
            }catch (e: IOException){
                HomeUiState.Error
            }catch(e: HttpException){
                HomeUiState.Error
            }
        }
    }


    fun deleteMhs(nim:String){
        viewModelScope.launch {
            try {
                mhs.deleteMahasiswa(nim)
            }catch (e: IOException){
                HomeUiState.Error
            }catch(e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}

