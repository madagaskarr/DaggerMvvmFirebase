package com.grk.daggermvvmfirebase.di

import android.app.Application
import com.grk.daggermvvmfirebase.activities.DashboardActivity
import com.grk.daggermvvmfirebase.activities.MainActivity
import com.grk.daggermvvmfirebase.di.modules.ApplicationModule
import com.grk.daggermvvmfirebase.di.modules.FirebaseModule
import com.grk.daggermvvmfirebase.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, FirebaseModule::class, ViewModelModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun injectMainActivity(activity: MainActivity)

    fun injectDashboardActivity(activity: DashboardActivity)


}