package com.dyedfox.gitreposearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import com.dyedfox.gitreposearch.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainPresenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                textView_search_for_result.visibility = View.GONE

                if (newText.length > 2 ) {
                    cleanRecycler()
                    initRecycler(newText.replace("\\s".toRegex(), ""))

                }
                else {
                    cleanRecycler()
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                initRecycler(query.replace("\\s".toRegex(), ""))

                return false
            }
        }
        )

    }

    fun initRecycler(name: String) {
        mainPresenter.initRecycler(name)
    }

    fun cleanRecycler() {
        mainPresenter.clearRecycler()
    }
}
