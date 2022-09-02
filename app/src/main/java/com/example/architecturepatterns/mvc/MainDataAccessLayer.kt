package com.example.architecturepatterns.mvc

import com.example.architecturepatterns.models.domain.Movie
import com.example.architecturepatterns.models.network.asDomainModel
import com.example.architecturepatterns.repos.MainRepo
import kotlinx.coroutines.*

class MainDataAccessLayer(
) {

    private val observers = mutableListOf<MovieObserver>()
    private var job: Job?=null
    var moviesList:List<Movie>?=null

    fun register(ob:MovieObserver)= observers.add(ob)

    fun deRegister(ob: MovieObserver){
        if (observers.isEmpty()){
            job?.cancel()
        }
        observers.remove(ob)
    }

    private fun notify(action: (MovieObserver) -> Unit) {
        observers.filterIsInstance<MovieObserver>().onEach { action(it) }
    }

    fun getTopMovies(){
        job =  CoroutineScope(Dispatchers.IO).launch {
            try {
                notify (MovieObserver::showLoader )
                val response = MainRepo.getTopMovies()
                if (response.items.isEmpty()){
                    notify ( MovieObserver::showThereIsNoMovies )

                }else{
                    moviesList= response.items.asDomainModel()
                    notify ( MovieObserver::showMovies )
                }

            }catch (e:Exception){
                e.printStackTrace()
                if (e !is CancellationException){
                    notify ( MovieObserver::showErrorMessage )
                }
            }

        }

    }

}