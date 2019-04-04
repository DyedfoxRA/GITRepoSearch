package com.dyedfox.gitreposearch.useCases

import android.util.Log
import com.dyedfox.gitreposearch.utils.NetworkHelper
import com.dyedfox.gitreposearch.model.Item


class MainUseCase() : BaseUseCase() {

    suspend fun getReposResponse(name: String): List<Item>? {
        if (checkNetworkConnection()) {
            NetworkHelper
                .getClient()
                .getRepos(name)
                .await()
                .let {
                    Log.e("ListSize1", it.body()?.items?.size.toString())
                    return when (it.code()) {
                        200 -> it.body()?.items
                        else -> emptyList()
                    }
                }
        } else return emptyList()
    }
}