package com.dyedfox.gitreposearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.dyedfox.gitreposearch.R
import com.dyedfox.gitreposearch.model.Item

class RecyclerViewGitAdapter(var listOfItems: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerViewGitViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewGitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val vh = RecyclerViewGitViewHolder(layoutInflater.inflate(R.layout.repo_item, parent, false))


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
        holder.getOwnerOfRepo().let {
            it.text = item.owner.login
        }
        holder.getLanguageOfRepo().let {
            it.text = item.language.toString()
        }
        holder.getUrlOfRepo().let {
            it.text = item.url
        }
        holder.getDescription().let {
            it.text = item.description
        }
        holder.getNameOfRepo().setOnClickListener {

            val builder = AlertDialog.Builder(it.context)


            builder.setTitle("App background color")

            builder.setMessage("Are you want to set the app background color to RED?")

            builder.setPositiveButton("YES") { dialog, which ->
                dialog.dismiss()
            }


            builder.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }



            builder.setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()

            }


            val dialog: AlertDialog = builder.create()


            dialog.show()
        }


    }
}






