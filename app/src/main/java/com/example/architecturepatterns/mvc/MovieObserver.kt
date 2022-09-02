package com.example.architecturepatterns.mvc

import com.example.architecturepatterns.models.domain.Movie

interface MovieObserver {

    fun showLoader()

    fun showMovies()

    fun showErrorMessage()

    fun showThereIsNoMovies()
}