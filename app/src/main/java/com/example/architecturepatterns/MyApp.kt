package com.example.architecturepatterns

import android.app.Application
import com.example.architecturepatterns.rest.RetrofitObject

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitObject.init()
    }
}