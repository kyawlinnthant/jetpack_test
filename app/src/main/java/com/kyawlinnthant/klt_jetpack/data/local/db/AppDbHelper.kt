package com.kyawlinnthant.klt_jetpack.data.local.db
import androidx.paging.DataSource
import com.kyawlinnthant.klt_jetpack.model.db.News
import com.kyawlinnthant.pagingtest.data.db.room.NewsDatabase

open class AppDbHelper(val database : NewsDatabase): DbHelper {
    override suspend fun saveNews(model: List<News>)  = database.getNewsDao().saveNews(model)
//    override suspend fun getNews(): DataSource.Factory<Int, News> = database.getNewsDao().getNews()

}