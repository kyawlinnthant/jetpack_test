package com.kyawlinnthant.klt_jetpack.ui.technology

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawlinnthant.klt_jetpack.R
import com.kyawlinnthant.klt_jetpack.base.BaseFragment
import com.kyawlinnthant.klt_jetpack.model.db.News
import com.kyawlinnthant.klt_jetpack.paging.NewsAdapter
import com.kyawlinnthant.klt_jetpack.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_technology.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TechnologyFragment : BaseFragment() , TechnologyNavigator {
    override fun setupRecyclerView() {
        adapter = NewsAdapter { getItemClick(it) }.apply {
            technology_recycler.layoutManager = LinearLayoutManager(context)
            technology_recycler.adapter = this
        }
    }

    override fun setupSwipeRefresh() {
        technology_swipe.setOnRefreshListener {

            Toast.makeText(context,"Technology is notified", Toast.LENGTH_LONG).show()
            technology_swipe.isRefreshing = false
        }
    }

    override fun setupData(data: PagedList<News>) {
       adapter?.submitList(data)
    }

    private val vm: MainViewModel by viewModel()
    private var adapter : NewsAdapter? = null
    override val layoutId: Int get() = R.layout.fragment_technology

    override fun observe() {
        vm.data.observe(this, Observer{ setupData(it) })
    }

    override fun initUi() {
        vm.getByType("technology")
        setupRecyclerView()
        setupSwipeRefresh()
        Toast.makeText(context,"Techno",Toast.LENGTH_LONG).show()
    }

    private fun getItemClick(position: Int) {
        val item = adapter?.getClickItem(position)
        Toast.makeText(context, item.toString(), Toast.LENGTH_LONG).show()
    }
}