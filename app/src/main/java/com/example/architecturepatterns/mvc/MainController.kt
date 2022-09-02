package com.example.architecturepatterns.mvc

import com.example.architecturepatterns.models.network.asDomainModel
import com.example.architecturepatterns.repos.MainRepo
import kotlinx.coroutines.*
import java.lang.ref.WeakReference

class MainController(val dataAccessLayer: MainDataAccessLayer) {

    fun onScreenLoaded(){
        dataAccessLayer.getTopMovies()
    }

}