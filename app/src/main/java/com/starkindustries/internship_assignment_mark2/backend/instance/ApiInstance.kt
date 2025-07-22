package com.starkindustries.internship_assignment_mark2.backend.instance

import com.google.gson.GsonBuilder
import com.starkindustries.internship_assignment_mark2.backend.api.ItemApi
import com.starkindustries.internship_assignment_mark2.keys.Keys
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiInstance {

    val api: ItemApi by lazy {

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder().setLenient().create()

        Retrofit.Builder()
            .baseUrl(Keys.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ItemApi::class.java)

    }
}