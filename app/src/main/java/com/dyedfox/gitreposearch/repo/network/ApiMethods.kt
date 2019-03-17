package com.dyedfox.gitreposearch.repo.network

import com.dyedfox.gitreposearch.model.RepoResponse
import com.dyedfox.gitreposearch.model.entity.Item
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMethods {

    @GET("{search_text}")
    fun getRepos(@Path("search_text") search_text: String): Deferred<Response<RepoResponse>>
}