package com.kyawlinnthant.klt_jetpack.ui.sport

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawlinnthant.klt_jetpack.R
import com.kyawlinnthant.klt_jetpack.base.BaseFragment
import com.kyawlinnthant.klt_jetpack.model.db.News
import com.kyawlinnthant.klt_jetpack.paging.NewsAdapter
import com.kyawlinnthant.klt_jetpack.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_sport.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SportFragment : BaseFragment(), SportNavigator {

    private val vm: MainViewModel by viewModel()
    private var adapter : NewsAdapter? = null
    override val layoutId: Int get() = R.layout.fragment_sport

    override fun observe() {
        vm.data.observe(this, Observer { setupData(it) })
    }

    override fun initUi() {
        vm.getByType("sport")
        setupRecyclerView()
        setupSwipeRefresh()
    }

    override fun setupSwipeRefresh() {
        sport_swipe.setOnRefreshListener {

            Toast.makeText(context,"Sport is notified", Toast.LENGTH_LONG).show()
            sport_swipe.isRefreshing = false
        }
    }

    override fun setupRecyclerView() {
        adapter = NewsAdapter { getItemClick(it) }.apply {
            sport_recycler.layoutManager = LinearLayoutManager(context)
            sport_recycler.adapter = this
        }
    }

    override fun setupData(data: PagedList<News>) {
        adapter?.submitList(data)
    }

    private fun getItemClick(position: Int) {
        val item = adapter?.getClickItem(position)
        Toast.makeText(context, item.toString(), Toast.LENGTH_LONG).show()
    }
}