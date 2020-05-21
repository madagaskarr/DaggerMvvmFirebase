package com.grk.daggermvvmfirebase

import android.content.Intent
import com.google.firebase.auth.FirebaseUser

interface AuthenticationManagerInterface {

    fun isUserAuthenticated(): Boolean

    fun createUserWithEmailAndPassword(email: String, password: String)

    fun signInWithEmailAndPassword(email: String, password: String)

    fun getCurrentUserId(): FirebaseUser?

    fun signTheUserOut()
}