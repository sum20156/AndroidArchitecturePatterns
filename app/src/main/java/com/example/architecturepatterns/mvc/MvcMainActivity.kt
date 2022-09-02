package com.example.architecturepatterns.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.architecturepatterns.R

class MvcMainActivity : AppCompatActivity(),MovieObserver {

    private val TAG = "MvcMainActivity"
    private val model = MainDataAccessLayer()
    private val controller = MainController(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller.onScreenLoaded()

    }

    override fun onResume() {
        super.onResume()
        model.register(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        model.deRegister(this)
    }

    override fun showLoader() {
        Log.i(TAG, "showLoader: ")
        //show progress bar
    }

    override fun showMovies() {
        Log.i(TAG, "showMovies: ")
        val data = model.moviesList
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

}