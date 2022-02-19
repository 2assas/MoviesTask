package com.example.gateways.networking

import com.example.files.AllFiles
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("movies")
    fun requestAllFiles(): Single<AllFiles>

}