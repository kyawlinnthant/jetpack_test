package com.kyawlinnthant.klt_jetpack.model.api

import com.kyawlinnthant.klt_jetpack.model.db.News

data class ResponseNews (
    val articles : List<News>
)