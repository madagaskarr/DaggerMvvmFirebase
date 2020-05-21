package com.grk.daggermvvmfirebase

import android.app.Application
import com.grk.daggermvvmfirebase.di.ApplicationComponent
import com.grk.daggermvvmfirebase.di.DaggerApplicationComponent


class MyApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

}