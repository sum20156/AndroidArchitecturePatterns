package com.example.architecturepatterns.mvp

import com.example.architecturepatterns.models.network.asDomainModel
import com.example.architecturepatterns.repos.MainRepo
import kotlinx.coroutines.*
import java.lang.ref.WeakReference

class MainPresenter(val mainView: WeakReference<MvpMainView>) {

    private var job: Job?=null

    fun getTopMovies(){
      job =  CoroutineScope(Dispatchers.IO).launch {
          try {
              mainView.get()?.showLoader()
              val response = MainRepo.getTopMovies()
              if (response.items.isEmpty()){
                  mainView.get()?.showThereIsNoMovies()
              }else
                mainView.get()?.showMovies(response.items.asDomainModel())
          }catch (e:Exception){
              e.printStackTrace()
              if (e !is CancellationException){
                  mainView.get()?.showErrorMessage()
              }
          }

        }

    }

    fun detach(){
        job?.cancel()
    }
}