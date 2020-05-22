package com.grk.daggermvvmfirebase.interfaces

import com.grk.daggermvvmfirebase.model.MyUser
import com.grk.daggermvvmfirebase.model.Recipe

interface DatabaseManagerInterface {

    fun addNewUser(user: MyUser)

    fun addRecipeToDatabase(recipes: Recipe)
}