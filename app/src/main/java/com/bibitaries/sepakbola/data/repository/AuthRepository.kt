package com.bibitaries.sepakbola.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.bibitaries.sepakbola.data.local.AuthPref
import com.bibitaries.sepakbola.data.model.ActionState
import com.bibitaries.sepakbola.data.model.AuthUser

class AuthRepository(val context: Context) {
    private val authPref: AuthPref by lazy { AuthPref(context) }

    val authUser = MutableLiveData<AuthUser>(authPref.authUser)
    val islogin = MutableLiveData<Boolean>(authPref.islogin)

    suspend fun login(email: String, password: String) : ActionState<AuthUser> {
        return authPref.login(email, password)
    }

    suspend fun register(user: AuthUser) : ActionState<AuthUser> {
        return authPref.register(user)
    }

    suspend fun logout() : ActionState<Boolean> {
        return authPref.logout()
    }
}