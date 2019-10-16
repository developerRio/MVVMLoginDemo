package com.originalstocks.mvvmdemo.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyAPI {

    // a dummy url  who's end point is login suppose
    // creating a post request via retrofit client
    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        // body post params for auth
        @Field("email")email: String,
        @Field("password")password: String) : Call<ResponseBody>

    companion object{
        // to call this, just we need to use MyAPI.invoke() which will hit the API
        operator fun invoke() : MyAPI{
            return Retrofit.Builder().baseUrl("https://reqres.in/api/") // a dummy api
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java) // call the interface for this API url

        }

    }

}