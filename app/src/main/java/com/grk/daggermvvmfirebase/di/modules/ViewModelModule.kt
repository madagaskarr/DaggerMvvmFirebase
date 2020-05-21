package com.grk.daggermvvmfirebase.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grk.daggermvvmfirebase.viewModels.MainActivityViewModel
import com.grk.daggermvvmfirebase.di.viewModelFactory.MyViewModelProviderFactory
import com.grk.daggermvvmfirebase.di.viewModelFactory.ViewModelKey
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
