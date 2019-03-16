package com.dyedfox.gitreposearch.repo.network

import com.dyedfox.gitreposearch.utils.API_LINK
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkHelper {

    lateinit var client: ApiMethods

    constructor() {
        createClient()
    }

    private fun createClient() {

        val retrofit = Retrofit.Builder()
            .baseUrl(API_LINK)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        client = retrofit
            .create(ApiMethods::class.java)


    }
}