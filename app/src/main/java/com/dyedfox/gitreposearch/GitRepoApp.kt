package com.dyedfox.gitreposearch

import android.app.Application
import com.dyedfox.gitreposearch.repo.network.NetworkHelper

class GitRepoApp: Application() {

    companion object {
        var networkHelper: NetworkHelper? = null
    }

    override fun onCreate() {
        super.onCreate()
    }
}