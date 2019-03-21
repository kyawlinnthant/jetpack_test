package com.kyawlinnthant.klt_jetpack.app

import android.app.Application
import com.kyawlinnthant.klt_jetpack.di.appModule
import com.kyawlinnthant.klt_jetpack.di.dataModule
import com.squareup.leakcanary.LeakCanary
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(dataModule, appModule))
/*
        if (LeakCanary.isInAnalyzerProcess(this)) {
            //do heap analysis(just for debug)
            return
        }
        LeakCanary.install(this)*/
    }
}