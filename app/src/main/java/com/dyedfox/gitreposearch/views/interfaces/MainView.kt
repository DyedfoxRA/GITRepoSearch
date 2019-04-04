package com.dyedfox.gitreposearch.views.interfaces

import com.dyedfox.gitreposearch.model.Item

interface MainView {
    fun listIsNull()
    fun getRepoSuccess(it: List<Item>)

}
