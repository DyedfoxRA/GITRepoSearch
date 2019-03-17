package com.dyedfox.gitreposearch.presenter

import androidx.recyclerview.widget.LinearLayoutManager
import com.dyedfox.gitreposearch.MainActivity
import com.dyedfox.gitreposearch.adapter.RecyclerViewGitAdapter
import com.dyedfox.gitreposearch.model.entity.Item
import com.dyedfox.gitreposearch.useCases.MainUseCase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(val activity: MainActivity) : BasePresenter() {

    private val mainUseCase = MainUseCase(activity)

    private val listOfRepoResponse = ArrayList<Item>()

    private lateinit var adapter: RecyclerViewGitAdapter

    fun getRepositories()
    {
        launch {
            mainUseCase.getReposResponse("tetris").let {
                listOfRepoResponse.addAll(it)
                withContext(Dispatchers.Main)
                {
                    adapter.notifyDataSetChanged()
                }

            }
        }
    }

    fun initRecycler() {
        adapter = RecyclerViewGitAdapter(listOfRepoResponse, activity)
        activity.recycler_view_repo.layoutManager = LinearLayoutManager(activity)
        activity.recycler_view_repo.adapter = adapter
        getRepositories()


    }
}