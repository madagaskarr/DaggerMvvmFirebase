package com.grk.daggermvvmfirebase.interfaces

import android.content.Context
import android.content.Intent
import com.google.firebase.auth.FirebaseUser

interface AuthenticationManagerInterface {

    fun isUserAuthenticated(): Boolean

    fun createUserWithEmailAndPassword(email: String, password: String)

    fun signInWithEmailAndPassword(email: String, password: String, context: Context, intent: Intent)

    fun getCurrentUser(): FirebaseUser?

    fun signTheUserOut()
}