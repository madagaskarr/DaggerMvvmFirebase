package com.grk.daggermvvmfirebase.managers

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.grk.daggermvvmfirebase.interfaces.DatabaseManagerInterface
import com.grk.daggermvvmfirebase.model.MyUser
import javax.inject.Inject

class DatabaseManager @Inject constructor(private val firestore: FirebaseFirestore, private val context: Context): DatabaseManagerInterface {

    companion object {
        private const val USERS_PATH = "users"
    }

    override fun addNewUser(user: MyUser) {
        firestore.collection(USERS_PATH).add(user)
    }
}