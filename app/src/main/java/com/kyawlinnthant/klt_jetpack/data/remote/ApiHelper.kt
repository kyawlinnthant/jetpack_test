package com.kyawlinnthant.klt_jetpack.data.remote

import com.kyawlinnthant.klt_jetpack.model.api.ResponseNews
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET("top-headlines")
    fun getData(
        @Query("apiKey") key: String,
        @Query("category") category: String,
        @Query("page") page: Int
    ): Deferred<Response<ResponseNews>>
}