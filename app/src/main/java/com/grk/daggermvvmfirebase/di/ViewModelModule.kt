package com.grk.daggermvvmfirebase.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grk.daggermvvmfirebase.MainActivityViewModel
import com.grk.daggermvvmfirebase.MyViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: MyViewModelProviderFactory): ViewModelProvider.Factory
}
