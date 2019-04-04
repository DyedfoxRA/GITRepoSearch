package com.dyedfox.gitreposearch.presenter

import android.util.Log
import com.dyedfox.gitreposearch.views.interfaces.MainView
import com.dyedfox.gitreposearch.useCases.MainUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter : BasePresenter() {

    var mainView: MainView? = null
    private val mainUseCase = MainUseCase()


    fun getRepositories(name: String) {
        launch {
            mainUseCase.getReposResponse(name).let {
                withContext(Dispatchers.Main)
                {
                    if (it.isNullOrEmpty()) {
                        if (mainView != null)
                            mainView!!.listIsNull()
                    } else {
                        Log.e("ListSize", it.size.toString())
                        if (mainView != null)
                            mainView!!.getRepoSuccess(it)
                    }
                }

            }
        }
    }


}