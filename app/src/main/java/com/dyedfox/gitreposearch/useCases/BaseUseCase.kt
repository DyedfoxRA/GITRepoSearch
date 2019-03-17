package com.dyedfox.gitreposearch.useCases

import android.content.Context
import android.net.ConnectivityManager
import com.dyedfox.gitreposearch.GitRepoApp.Companion.networkHelper
import com.dyedfox.gitreposearch.repo.network.NetworkHelper

open class BaseUseCase(val context: Context) {

    fun getNetworkHelper(): NetworkHelper {
        if (networkHelper == null)
            networkHelper = NetworkHelper()

        return networkHelper!!
    }

    fun checkNetworkConnection(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}