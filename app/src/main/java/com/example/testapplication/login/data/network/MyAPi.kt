package com.example.testapplication.login.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyAPi{

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<ResponseBody>

    companion object{
        operator fun invoke(): MyAPi{
            return Retrofit.Builder()
                .baseUrl("https://debo-task-manager.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPi::class.java)
        }
    }
}