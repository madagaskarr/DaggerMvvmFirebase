package com.grk.daggermvvmfirebase.di.modules

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuthetication(): FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideFirebaseAFirestore(): FirebaseFirestore = Firebase.firestore

}