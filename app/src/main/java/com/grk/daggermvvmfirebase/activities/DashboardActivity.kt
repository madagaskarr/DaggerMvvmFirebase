package com.grk.daggermvvmfirebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.grk.daggermvvmfirebase.MyApplication
import com.grk.daggermvvmfirebase.R
import com.grk.daggermvvmfirebase.managers.AuthenticationManager
import com.grk.daggermvvmfirebase.model.Ingredient
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

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).applicationComponent.injectDashboardActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        dashboardActivityViewModel = viewModelFactory.create(DashboardActivityViewModel::class.java)

    }

    fun addNewUser(view: View) {

        var tigran = MyUser(
            id = authenticationManager.getCurrentUser()!!.uid,
            name = "Tigran",
            imageUrl = "https://firebase.google.com/docs/firestore/query-data/get-data",
            favouriteRecipes = mutableListOf(Recipe("342573456347583", "Kebab in Tsatsiki", true, mutableListOf(Ingredient("572573456347583","Beef"), Ingredient("572473456347583","Matsoon")))),
            createdRecipes = mutableListOf(Recipe("342573456347583", "Kebab in Tsatsiki", true, mutableListOf(Ingredient("572573456347583","Beef"), Ingredient("572473456347583","Matsoon"))))
        )

        dashboardActivityViewModel.addNewUser(tigran)
    }

    fun addRecipe(view: View) {
        var recipe = Recipe("342573456347583", "Kebab in Tsatsiki", true, mutableListOf(Ingredient("572573456347583","Beef"), Ingredient("572473456347583","Matsoon")))
        dashboardActivityViewModel.addNewRecipe(recipe)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        authenticationManager.signTheUserOut()
    }
}
