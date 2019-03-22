package com.kyawlinnthant.klt_jetpack.ui

import androidx.paging.LivePagedListBuilder
import com.kyawlinnthant.klt_jetpack.base.BaseViewModel
import com.kyawlinnthant.klt_jetpack.data.DataManager
import com.kyawlinnthant.klt_jetpack.model.db.News
import com.kyawlinnthant.klt_jetpack.paging.NewsDataSourceFactory

class MainViewModel(dataManager: DataManager) : BaseViewModel(dataManager) {

    private var category: String? = null
    val data by lazy {
        LivePagedListBuilder<Int, News>(NewsDataSourceFactory(job, dataManager, category!!), 25).build()
    }

    fun getByType(category: String) {
        this.category = category
    }

}