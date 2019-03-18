package com.dyedfox.gitreposearch.useCases

import android.content.Context
import android.util.Log
import com.dyedfox.gitreposearch.model.entity.Item


class MainUseCase(context_: Context) : BaseUseCase(context_) {

    suspend fun getReposResponse(name : String): List<Item>? {

        val resp = getNetworkHelper()
            .client
            .getRepos(name)
            .await()
            .body()?.items

        Log.e("res",resp.toString())
            return resp
    }
}