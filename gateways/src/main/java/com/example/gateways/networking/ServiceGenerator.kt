package com.example.gateways.networking

import com.example.gateways.networking.ApiService
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator{

    fun <S> provideApiService(serviceClass: Class<ApiService>): ApiService {
        val gson = GsonBuilder()
            .setLenient()
            .create()
         val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        logging.level = HttpLoggingInterceptor.Level.BODY
        val builder = Retrofit.Builder()
        val clientBuilder = OkHttpClient.Builder().addInterceptor(logging)
        clientBuilder.addInterceptor { chain: Interceptor.Chain->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Accept", "application/json")
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        clientBuilder.connectTimeout(50, TimeUnit.SECONDS)
        clientBuilder.readTimeout(50, TimeUnit.SECONDS)
        val client = clientBuilder.build()
        builder.baseUrl("https://nagwa.free.beeceptor.com/")
        builder.client(client)
        builder.addConverterFactory(GsonConverterFactory.create(gson))
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        val adapter = builder.build()
        return adapter.create(serviceClass)
    }

}