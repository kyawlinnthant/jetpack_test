package com.kyawlinnthant.klt_jetpack.paging

import androidx.paging.DataSource
import com.kyawlinnthant.klt_jetpack.data.DataManager
import com.kyawlinnthant.klt_jetpack.model.db.News
import kotlinx.coroutines.Job

class NewsDataSourceFactory(
    private val job: Job,
    private val dataManager: DataManager,
    private val category : String
) : DataSource.Factory<Int, News>() {

    override fun create(): DataSource<Int, News> = NewsDataSource(job,dataManager,category)
}