package com.dyedfox.gitreposearch.useCases

import android.content.Context
import android.net.ConnectivityManager
import com.dyedfox.gitreposearch.App.Companion.context

open class BaseUseCase() {


    fun checkNetworkConnection(): Boolean {
        return if (context != null) {
            val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo != null && networkInfo.isConnected
        } else
            false
    }
}