package com.example.testapplication.login.ui.auth

import androidx.lifecycle.LiveData
import com.example.testapplication.login.model.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(message: String)
}