package com.grk.daggermvvmfirebase.managers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.grk.daggermvvmfirebase.interfaces.AuthenticationManagerInterface
import javax.inject.Inject

class AuthenticationManager @Inject constructor(private val firebaseAuth: FirebaseAuth, private val context: Context):
    AuthenticationManagerInterface {

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

    override fun signInWithEmailAndPassword(email: String, password: String, context: Context, intent: Intent) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "${result.exception}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun signTheUserOut() {
        firebaseAuth.signOut()
    }
}