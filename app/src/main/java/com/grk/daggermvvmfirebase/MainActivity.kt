package com.grk.daggermvvmfirebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).applicationComponent.injectMainActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = viewModelFactory.create(MainActivityViewModel::class.java)

        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
    }

    fun signUserIn(view: View) {
        mainActivityViewModel.signInWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString(), this, Intent(this, DashboardActivity::class.java))

    }

    fun registerNewUser(view: View) {
        mainActivityViewModel.createUserWithEmailAndPassword(emailEditText.text.toString(), passwordEditText.text.toString())
    }
}
