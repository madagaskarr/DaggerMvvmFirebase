package com.grk.daggermvvmfirebase.managers

import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.grk.daggermvvmfirebase.interfaces.DatabaseManagerInterface
import com.grk.daggermvvmfirebase.model.MyUser
import com.grk.daggermvvmfirebase.model.Recipe
import javax.inject.Inject

class DatabaseManager @Inject constructor(private val firestore: FirebaseFirestore, private val context: Context): DatabaseManagerInterface {

    companion object {
        private const val USERS_COLLECTION_PATH = "users"
        private const val RECIPES_COLLECTION_PATH = "recipes"
    }

    override fun addNewUser(user: MyUser) {
        firestore.collection(USERS_COLLECTION_PATH).add(user).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "${result.exception}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun addRecipeToDatabase(recipes: Recipe) {
        firestore.collection(RECIPES_COLLECTION_PATH).add(recipes).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "${result.exception}", Toast.LENGTH_LONG).show()
            }
        }    }
}