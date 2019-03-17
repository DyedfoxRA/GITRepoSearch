package com.dyedfox.gitreposearch.useCases

import android.content.Context
import com.dyedfox.gitreposearch.model.entity.Item


class MainUseCase(context_: Context) : BaseUseCase(context_) {

    suspend fun getReposResponse(name : String): List<Item> {

        val resp = getNetworkHelper()
            .client
            .getRepos(name)
            .await()
            .body()?.items
            return resp!!
    }
}