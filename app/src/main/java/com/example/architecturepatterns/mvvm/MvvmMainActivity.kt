package com.example.architecturepatterns.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.architecturepatterns.R
import com.example.architecturepatterns.models.domain.Movie
import java.lang.ref.WeakReference

class MvvmMainActivity : AppCompatActivity(){
    private val TAG = "MainActivity"
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observerNetWorkCalls()
        viewModel.onScreenLoaded()
    }

    private fun observerNetWorkCalls() {
        viewModel.errorMessage.observe(this){
            Log.i(TAG, "showError: ")
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this){
            Log.i(TAG, "showLoader: ")
            //show progressbar/progress dialog
        }

        viewModel.movieList.observe(this){
            Log.i(TAG, "showMovies: ")
            //show data in recyclerview/listview
        }
    }


}