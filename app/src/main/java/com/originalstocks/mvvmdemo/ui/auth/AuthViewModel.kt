package com.originalstocks.mvvmdemo.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.originalstocks.mvvmdemo.data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    var email : String ? = null
    var password : String ? = null
    var authListener : AuthListener? = null

    fun onLoginButtonClick(view: View){
        // login process started
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Incorrect email or password.")
            return
        }else{
                       // fetching live data from UserRepository
            val loginResponse = UserRepository().userLogin( email !!, password !!)

            // Success listener
            authListener?.onSuccess(loginResponse)

        }

    }

}