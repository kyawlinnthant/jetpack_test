package com.kyawlinnthant.klt_jetpack.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class News (
    @PrimaryKey(autoGenerate = true)val id: Int,
    val author : String?,
    val title : String,
    val description : String,
    val urlToImage : String,
    val publishedAt : String
)