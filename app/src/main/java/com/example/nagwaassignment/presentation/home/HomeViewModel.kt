package com.example.nagwaassignment.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.downloaded.showAllInDownloads
import com.example.files.AllFiles
import com.example.files.showAllFiles
import com.example.nagwaassignment.framework.di.RetrofitModule
import com.example.gateways.networking.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(retrofitModule: RetrofitModule) {
    val allFilesMutableLiveData: MutableLiveData<AllFiles> = MutableLiveData()

    private var api : ApiService = retrofitModule.provideApiService()

    @SuppressLint("CheckResult")
    fun requestAllFiles(){
      showAllFiles()
    }
}