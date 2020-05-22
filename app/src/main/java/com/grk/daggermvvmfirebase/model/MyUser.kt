package com.grk.daggermvvmfirebase.model

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class MyUser(var id: String,
                  var name: String,
                  var imageUrl: String,
                  var favouriteRecipes: MutableList<Recipe>,
                  var createdRecipes: MutableList<Recipe>)

@IgnoreExtraProperties
data class Recipe(var id: String,
                  var title: String,
                  val isFavourite: Boolean,
                  var ingredients: MutableList<Ingredient>)

@IgnoreExtraProperties
data class Ingredient(var id: String, var title: String)