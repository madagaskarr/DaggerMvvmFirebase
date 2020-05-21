package com.grk.daggermvvmfirebase

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthenticationManager @Inject constructor(private val firebaseAuth: FirebaseAuth, private val context: Context): AuthenticationManagerInterface {

    override fun isUserAuthenticated(): Boolean {
        var isAuthenticated = false

        if (firebaseAuth.currentUser != null) {
            isAuthenticated = true
        }
        return isAuthenticated
    }

    override fun createUserWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "${result.exception}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun signInWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    override fun getCurrentUserId(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun signTheUserOut() {
        firebaseAuth.signOut()
    }
}