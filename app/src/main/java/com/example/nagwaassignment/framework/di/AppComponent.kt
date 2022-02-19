package com.example.nagwaassignment.framework.di

import android.content.Context
import com.example.nagwaassignment.MainActivity
import com.example.nagwaassignment.presentation.downloaded.DownloadedFragment
import com.example.nagwaassignment.presentation.home.HomeFragment
import com.example.nagwaassignment.presentation.inProgress.InProgressFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: DownloadedFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: InProgressFragment)

}