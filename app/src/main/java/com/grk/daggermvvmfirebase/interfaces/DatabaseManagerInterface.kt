package com.grk.daggermvvmfirebase.interfaces

import com.grk.daggermvvmfirebase.model.MyUser

interface DatabaseManagerInterface {

    fun addNewUser(user: MyUser)
}