package com.originalstocks.mvvmdemo.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.originalstocks.mvvmdemo.data.network.MyAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    // this repository will store the callbacks from the loginInterface, & pass the value to viewModel not on TabActivity

    // this function is returning the live data object of type string, which wll be passed to viewModel,
    fun userLogin(email: String, password: String): LiveData<String> {

        val loginResponse = MutableLiveData<String>()

        // injecting rhe userLogin fun
        MyAPI().userLogin(email, password).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loginResponse.value = t.message
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    loginResponse.value = response.body()?.string()
                } else {
                    loginResponse.value = response.errorBody()?.string()
                }
            }
        })
        return loginResponse
    }

}