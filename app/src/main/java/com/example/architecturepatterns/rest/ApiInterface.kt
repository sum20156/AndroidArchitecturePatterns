package com.example.architecturepatterns.rest

import com.example.architecturepatterns.Constants
import com.example.architecturepatterns.models.network.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(Constants.TOP250_MOVIES_ENDPOINT)
    suspend fun getTopMovies(
        @Path("api_key") apiKey:String = Constants.API_KEY
    ):MovieResponse
}