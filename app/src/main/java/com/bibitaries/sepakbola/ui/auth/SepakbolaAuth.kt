package com.bibitaries.sepakbola.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.bibitaries.sepakbola.data.model.ActionState
import com.bibitaries.sepakbola.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object SepakbolaAuth {

    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                if (callback != null) callback.invoke(resp)
            }
        }
    }

}