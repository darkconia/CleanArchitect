package com.poc.cleanarchitect

import android.app.Application
import com.poc.cleanarchitect.di.appModule
import com.poc.cleanarchitect.di.contributeModule
import com.poc.cleanarchitect.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application()
{
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Android context
            androidContext(this@MainApplication)
            // modules
           modules(
               appModule +
                       networkModule +
                       contributeModule
           )
        }
    }
}