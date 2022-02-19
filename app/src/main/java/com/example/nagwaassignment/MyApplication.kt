package com.example.nagwaassignment

import android.app.Application
import com.example.CoreDependencies
import com.example.gateways.DownloadsGatewayImplementer
import com.example.gateways.FilesGatewayImplementer
import com.example.gateways.GatewaysDependencies
import com.example.gateways.InProgressGatewayImplementer
import com.example.nagwaassignment.framework.di.AppComponent
import com.example.nagwaassignment.framework.di.DaggerAppComponent

open class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }
    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
    override fun onCreate() {
        super.onCreate()
        GatewaysDependencies.with(this)
        CoreDependencies.downloadsGateway(DownloadsGatewayImplementer())
        CoreDependencies.inProgressGateway(InProgressGatewayImplementer())
        CoreDependencies.filesGateway(FilesGatewayImplementer())
    }
}