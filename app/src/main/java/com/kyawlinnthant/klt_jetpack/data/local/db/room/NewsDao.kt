package com.kyawlinnthant.klt_jetpack.data.local.db.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kyawlinnthant.klt_jetpack.model.db.News

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(model: List<News>)

//    @Query("SELECT * FROM news_table")
//    suspend fun getNews() : DataSource.Factory<Int, News>
}