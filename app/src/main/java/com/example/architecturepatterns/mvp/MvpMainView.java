package com.example.architecturepatterns.mvp;

import com.example.architecturepatterns.models.domain.Movie;

import java.util.List;

public interface MvpMainView {

    void showLoader();

    void showMovies(List<Movie> movies);

    void showErrorMessage();

    void showThereIsNoMovies();
}

