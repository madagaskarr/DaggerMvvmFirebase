package com.grk.daggermvvmfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var authenticationManager: AuthenticationManager

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
    }

    fun signUserIn(view: View) {
        authenticationManager.signInWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString())

        if (authenticationManager.isUserAuthenticated()) {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }

    fun registerNewUser(view: View) {
        authenticationManager.createUserWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString())
    }
}
