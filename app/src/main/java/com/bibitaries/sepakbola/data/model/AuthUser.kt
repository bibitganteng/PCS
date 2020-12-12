package com.bibitaries.sepakbola.data.model

import android.provider.ContactsContract

data class AuthUser(
    val id: Int = 0,
    val email: String = "",
    val password: String = "",
    val fullName: String = ""
)
