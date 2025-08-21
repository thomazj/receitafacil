package com.example.receitafacil

import android.app.Application
import com.example.receitafacil.core.util.logging.DebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}