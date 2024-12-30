package com.example.prak9db

import android.app.Application
import com.example.prak9db.repository.AppContainer
import com.example.prak9db.repository.MahasiswaContainer

class MahasiswaApplications:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container= MahasiswaContainer()
    }
}