package com.example.nagwaassignment

import android.app.Application
import com.example.nagwaassignment.framework.di.AppComponent
import com.example.nagwaassignment.framework.di.DaggerAppComponent

open class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

}