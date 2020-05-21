package com.grk.daggermvvmfirebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grk.daggermvvmfirebase.MyApplication
import com.grk.daggermvvmfirebase.R
import com.grk.daggermvvmfirebase.managers.AuthenticationManager
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
