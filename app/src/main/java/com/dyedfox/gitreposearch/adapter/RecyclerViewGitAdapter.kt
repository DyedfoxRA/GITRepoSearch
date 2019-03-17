package com.dyedfox.gitreposearch.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyedfox.gitreposearch.R
import com.dyedfox.gitreposearch.model.entity.Item

class RecyclerViewGitAdapter(val listOfItems: List<Item>, val context: Context) :
    RecyclerView.Adapter<RecyclerViewGitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewGitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecyclerViewGitViewHolder(layoutInflater.inflate(R.layout.repo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return listOfItems.size
   }

    override fun onBindViewHolder(holder: RecyclerViewGitViewHolder, position: Int) {
        val item = listOfItems[position]

        holder.getNameOfRepo().let {
            it.text = item.name
        }
        holder.getOwnerOfRepo().let{
            it.text = item.owner.login
        }
        holder.getLanguageOfRepo().let{
            it.text = item.language.toString()
        }
        holder.getUrlOfRepo().let{
            it.text = item.url
        }
        holder.getDescription().let {
            it.text = item.description
        }
    }
}






