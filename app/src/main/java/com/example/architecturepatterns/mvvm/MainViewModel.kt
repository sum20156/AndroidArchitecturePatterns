package com.example.architecturepatterns.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturepatterns.models.domain.Movie
import com.example.architecturepatterns.models.network.asDomainModel
import com.example.architecturepatterns.repos.MainRepo
import kotlinx.coroutines.launch

class MainViewModel():ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val movieList = MutableLiveData<List<Movie>>()

    val loading = MutableLiveData<Boolean>()

    fun onScreenLoaded(){
        loading.postValue(true)
        viewModelScope.launch {
            try {
               val response =  MainRepo.getTopMovies()
                val uiList = response.items.asDomainModel()
                loading.postValue(false)
                movieList.postValue(uiList)
            }catch (e:Exception){
                loading.postValue(false)
                errorMessage.postValue(e.localizedMessage)
            }

        }
    }


}