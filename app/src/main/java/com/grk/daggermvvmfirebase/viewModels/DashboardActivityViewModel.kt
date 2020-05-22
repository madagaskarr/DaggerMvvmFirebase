package com.grk.daggermvvmfirebase.viewModels

import androidx.lifecycle.ViewModel
import com.grk.daggermvvmfirebase.managers.DatabaseManager
import com.grk.daggermvvmfirebase.model.MyUser
import com.grk.daggermvvmfirebase.model.Recipe
import javax.inject.Inject

class DashboardActivityViewModel@Inject constructor(private var databaseManager: DatabaseManager) : ViewModel() {

    fun addNewUser(user: MyUser) {
        databaseManager.addNewUser(user)
    }

    fun addNewRecipe(recipe: Recipe) {
        databaseManager.addRecipeToDatabase(recipe)
    }
}