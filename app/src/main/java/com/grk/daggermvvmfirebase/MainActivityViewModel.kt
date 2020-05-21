package com.grk.daggermvvmfirebase

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private var authenticationManager: AuthenticationManager) : ViewModel() {

    fun isUserAuthenticated(): Boolean {
        return authenticationManager.isUserAuthenticated()
    }

    fun createUserWithEmailAndPassword(email: String, password: String) {
        authenticationManager.createUserWithEmailAndPassword(email, password)
    }

    fun signInWithEmailAndPassword(email: String, password: String, context: Context, intent: Intent) {
        authenticationManager.signInWithEmailAndPassword(email, password, context, intent)
    }

    fun getCurrentUserId(): FirebaseUser? {
        return authenticationManager.getCurrentUser()
    }

    fun signTheUserOut() {
        authenticationManager.signTheUserOut()
    }
}