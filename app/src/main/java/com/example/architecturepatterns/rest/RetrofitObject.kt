package com.example.architecturepatterns.rest

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    private lateinit var retrofit: Retrofit

    fun init(){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttp =OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .build()
            chain.proceed(newRequest)
        }).addInterceptor(loggingInterceptor).build()

        retrofit = Retrofit.Builder().client(okHttp)
            .addConverterFactory(GsonConverterFactory.create()).baseUrl("https://imdb-api.com/").build()
    }

    fun getApiInterface(): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

}