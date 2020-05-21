package com.grk.daggermvvmfirebase.di

import android.app.Application
import android.content.Context
import com.grk.daggermvvmfirebase.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)


}