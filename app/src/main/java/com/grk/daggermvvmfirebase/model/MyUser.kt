package com.grk.daggermvvmfirebase.model

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class MyUser(var id: String, var name: String, var recipe: Recipe)

@IgnoreExtraProperties
data class Recipe(var id: String, var title: String)