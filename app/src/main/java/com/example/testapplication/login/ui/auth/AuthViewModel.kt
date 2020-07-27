package com.example.testapplication.login.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.testapplication.login.data.repositories.UserRepository

class AuthViewModel: ViewModel(){
    val email: String ?= null
    val password: String ?= null

    var authListener: AuthListener ?= null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid username or password")
            return
        }

        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }
}