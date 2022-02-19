package com.example.gateways

import android.annotation.SuppressLint
import com.example.FailedToRequestException
import com.example.files.AllFiles
import com.example.files.FilesGateway
import com.example.gateways.networking.ApiService
import com.example.gateways.networking.ServiceGenerator

class FilesGatewayImplementer : FilesGateway {
    var apiClient = ServiceGenerator.provideApiService<Any>(
        ApiService::class.java
    )
    @SuppressLint("CheckResult")
    @Throws(FailedToRequestException::class)
    override fun requestAllFiles(): AllFiles {
        TODO("Not yet implemented")
    }

    override fun saveAllFiles(allFiles: AllFiles) {

    }

    override fun loadAllFiles(): AllFiles? {
        TODO("Not yet implemented")
    }
}