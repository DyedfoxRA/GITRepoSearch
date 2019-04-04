package com.dyedfox.gitreposearch.model

import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)