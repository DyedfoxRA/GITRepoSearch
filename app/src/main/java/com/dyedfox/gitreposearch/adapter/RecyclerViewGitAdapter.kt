package com.dyedfox.gitreposearch.adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dyedfox.gitreposearch.R
import com.dyedfox.gitreposearch.model.entity.Item

class RecyclerViewGitAdapter(val listOfItems: List<Item>, val context: Context) :
    RecyclerView.Adapter<RecyclerViewGitViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewGitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val vh = RecyclerViewGitViewHolder(layoutInflater.inflate(R.layout.repo_item, parent, false))

        vh.itemView.setOnClickListener {

            val dg = Dialog(context)

            dg.setContentView(R.layout.repo_dialog)

            dg.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dg.show()
        }

        return vh
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






