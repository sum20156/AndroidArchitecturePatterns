package com.example.architecturepatterns.repos

import com.example.architecturepatterns.models.network.MovieResponse
import com.example.architecturepatterns.rest.RetrofitObject

object MainRepo {

    private val api = RetrofitObject.getApiInterface()

    suspend fun getTopMovies(): MovieResponse {
        return api.getTopMovies()
    }

}