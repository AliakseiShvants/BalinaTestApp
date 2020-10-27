package com.shvants.balinatestapp

import android.app.Application
import com.shvants.balinatestapp.koin.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BalinaTestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BalinaTestApp)
            modules(koinModules)
        }
    }
}