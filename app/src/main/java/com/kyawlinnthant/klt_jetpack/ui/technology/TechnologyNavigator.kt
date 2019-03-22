package com.kyawlinnthant.klt_jetpack.ui.technology

import androidx.paging.PagedList
import com.kyawlinnthant.klt_jetpack.model.db.News

interface TechnologyNavigator {
    fun setupRecyclerView()
    fun setupSwipeRefresh()
    fun setupData(data : PagedList<News>)
}