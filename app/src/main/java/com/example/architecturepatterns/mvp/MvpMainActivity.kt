package com.example.architecturepatterns.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.architecturepatterns.R
import com.example.architecturepatterns.models.domain.Movie
import java.lang.ref.WeakReference

class MvpMainActivity : AppCompatActivity(),
    MvpMainView {
    private val TAG = "MainActivity"
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(WeakReference(this))
        presenter.getTopMovies()
    }

    override fun showLoader() {
        Log.i(TAG, "showLoader: ")
        //show progress bar
    }

    override fun showMovies(movies: MutableList<Movie>?) {
        Log.i(TAG, "showMovies: ")
        //show the data in ui using recyclerview/listview
    }

    override fun showErrorMessage() {
        Log.i(TAG, "showErrorMessage: ")
        //alert user that api is failed by using toast/dialog etc
    }

    override fun showThereIsNoMovies() {
        Log.i(TAG, "showThereIsNoMovies: ")
        //show an empty ui
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: ")
    }
}