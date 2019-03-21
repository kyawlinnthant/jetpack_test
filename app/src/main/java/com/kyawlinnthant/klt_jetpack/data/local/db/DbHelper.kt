package com.kyawlinnthant.klt_jetpack.data.local.db
import androidx.paging.DataSource
import com.kyawlinnthant.klt_jetpack.model.db.News

interface DbHelper {

    suspend fun saveNews(model: List<News>)
//    suspend fun getNews():DataSource.Factory<Int,News>

}