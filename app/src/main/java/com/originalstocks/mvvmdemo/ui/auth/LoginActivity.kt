package com.originalstocks.mvvmdemo.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.originalstocks.mvvmdemo.R
import com.originalstocks.mvvmdemo.databinding.ActivityLoginBinding
import com.originalstocks.mvvmdemo.ui.home.TabActivity
import com.originalstocks.mvvmdemo.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {
    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding data
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        // initialising viewModel
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel :: class.java)
        /*binding up the data with view model*/
        binding.viewmodel = viewModel

        /*adding listener for callbacks*/
        viewModel.authListener = this
    }

    override fun onStarted() {
        toast("Login started")
        Log.i(TAG, "Login response via Live Data = started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            toast(it)
            Log.i(TAG, "Login response via Live Data = $it")
            // sending user to tab home activity
            val intent = Intent(this, TabActivity::class.java)
            startActivity(intent)
            finish()

        })

    }

    override fun onFailure(message: String) {
        toast(message)
    }

}
