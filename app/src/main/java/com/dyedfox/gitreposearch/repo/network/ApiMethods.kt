package com.dyedfox.gitreposearch.repo.network

import com.dyedfox.gitreposearch.model.RepoResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMethods {

    @GET("repositories")
    fun getRepos(@Query("q") search_text: String): Deferred<Response<RepoResponse>>
}