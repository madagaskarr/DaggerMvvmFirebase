package com.grk.daggermvvmfirebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.grk.daggermvvmfirebase.MyApplication
import com.grk.daggermvvmfirebase.R
import com.grk.daggermvvmfirebase.managers.AuthenticationManager
import com.grk.daggermvvmfirebase.model.MyUser
import com.grk.daggermvvmfirebase.model.Recipe
import com.grk.daggermvvmfirebase.viewModels.DashboardActivityViewModel
import com.grk.daggermvvmfirebase.viewModels.MainActivityViewModel
import javax.inject.Inject

class DashboardActivity : AppCompatActivity() {

    @Inject
    lateinit var authenticationManager: AuthenticationManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var dashboardActivityViewModel: DashboardActivityViewModel
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).applicationComponent.injectDashboardActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        dashboardActivityViewModel = viewModelFactory.create(DashboardActivityViewModel::class.java)

    }

    fun addNewUser(view: View) {
        dashboardActivityViewModel.addNewUser(MyUser(authenticationManager.getCurrentUser()!!.uid, "TIgran", Recipe("sfsdf","sdfdsfsdfs")))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        authenticationManager.signTheUserOut()
    }
}
