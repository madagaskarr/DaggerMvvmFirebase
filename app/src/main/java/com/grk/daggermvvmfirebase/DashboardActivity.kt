package com.grk.daggermvvmfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class DashboardActivity : AppCompatActivity() {

    @Inject
    lateinit var authenticationManager: AuthenticationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).applicationComponent.injectDashboardActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        authenticationManager.signTheUserOut()
    }
}
