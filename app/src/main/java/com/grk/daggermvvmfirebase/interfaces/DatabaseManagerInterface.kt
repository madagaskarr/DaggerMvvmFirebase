package com.grk.daggermvvmfirebase.interfaces

import androidx.lifecycle.LiveData
import com.grk.daggermvvmfirebase.model.MyUser
import com.grk.daggermvvmfirebase.model.Recipe

interface DatabaseManagerInterface {

    fun addNewUser(user: MyUser)

    fun addRecipeToDatabase(recipe: Recipe)

    fun getAllRecipes()

}