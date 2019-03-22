package com.kyawlinnthant.klt_jetpack.ui.sport

import androidx.paging.PagedList
import com.kyawlinnthant.klt_jetpack.model.db.News

interface SportNavigator {

    fun setupRecyclerView()
    fun setupSwipeRefresh()
    fun setupData(data : PagedList<News>)
}