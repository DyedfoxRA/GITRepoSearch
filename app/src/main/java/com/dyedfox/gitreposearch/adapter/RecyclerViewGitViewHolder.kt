package com.dyedfox.gitreposearch.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.repo_item.view.*

class RecyclerViewGitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var name_repo : TextView = itemView.name_repo

    private var owner_repo : TextView = itemView.owner_repo

    private var language_repo : TextView = itemView.language_repo

    private var url_repo : TextView = itemView.url_repo

    fun getNameOfRepo() = name_repo

    fun getOwnerOfRepo() = owner_repo

    fun getLanguageOfRepo() = language_repo

    fun getUrlOfRepo() = url_repo
}