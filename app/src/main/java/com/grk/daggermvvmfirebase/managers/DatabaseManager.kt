package com.grk.daggermvvmfirebase.managers

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import com.grk.daggermvvmfirebase.interfaces.DatabaseManagerInterface
import com.grk.daggermvvmfirebase.model.MyUser
import com.grk.daggermvvmfirebase.model.Recipe
import javax.inject.Inject

class DatabaseManager @Inject constructor(private val firestore: FirebaseFirestore, private val context: Context): DatabaseManagerInterface {

    private lateinit var recipesLiveData: MutableLiveData<MutableList<Recipe>>

    companion object {
        private const val USERS_COLLECTION_PATH = "users"
        private const val RECIPES_COLLECTION_PATH = "recipes"
    }

    init {
        recipesLiveData = MutableLiveData()
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

    override fun addRecipeToDatabase(recipe: Recipe) {
        val recipeDocument = firestore.collection(RECIPES_COLLECTION_PATH).document()
        recipe.id = recipeDocument.id

        recipeDocument.set(recipe).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "${result.exception}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getAllRecipes() {
        var allRecipes = mutableListOf<Recipe>()

        firestore.collection(RECIPES_COLLECTION_PATH).get().addOnSuccessListener {  collectionSnapshot ->
            collectionSnapshot.documents.forEach { documentSpnashot ->
                allRecipes.add(documentSpnashot.toObject(Recipe::class.java)!!)
            }
            recipesLiveData.postValue(allRecipes)
        }
    }

    fun getAllRecipesLiveData(): MutableLiveData<MutableList<Recipe>> {
        return recipesLiveData
    }
}