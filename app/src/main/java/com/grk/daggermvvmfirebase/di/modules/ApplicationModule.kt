package com.grk.daggermvvmfirebase.di.modules

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import com.grk.daggermvvmfirebase.managers.AuthenticationManager
import com.grk.daggermvvmfirebase.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun provideAuthenticationManager(firebaseAuth: FirebaseAuth, context: Application): AuthenticationManager {
        return AuthenticationManager(
            firebaseAuth = firebaseAuth,
            context = context
        )
    }
}