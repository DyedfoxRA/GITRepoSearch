package com.dyedfox.gitreposearch.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.dyedfox.gitreposearch.views.interfaces.MainView
import com.dyedfox.gitreposearch.R
import com.dyedfox.gitreposearch.adapter.RecyclerViewGitAdapter
import com.dyedfox.gitreposearch.model.Item
import com.dyedfox.gitreposearch.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var adapter: RecyclerViewGitAdapter


    private val mainPresenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.mainView = this
        initRecycler()
        initSearchView()

    }

    private fun initSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                textView_search_for_result.visibility = View.GONE

                if (newText.length > 2) {
                    mainPresenter.getRepositories(newText)

                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                mainPresenter.getRepositories(query)

                return false
            }
        }
        )
    }

    private fun initRecycler() {
        adapter = RecyclerViewGitAdapter(ArrayList())
        recycler_view_repo.layoutManager = LinearLayoutManager(this)
        recycler_view_repo.adapter = adapter

    }


    override fun listIsNull() {
        adapter.listOfItems.clear()
        adapter.notifyDataSetChanged()
    }

    override fun getRepoSuccess(it: List<Item>) {

        adapter.listOfItems.clear()
        adapter.listOfItems.addAll(it)
        adapter.notifyDataSetChanged()
    }

}
