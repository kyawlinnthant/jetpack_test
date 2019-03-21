package com.kyawlinnthant.klt_jetpack.data

import com.kyawlinnthant.klt_jetpack.data.local.db.DbHelper
import com.kyawlinnthant.klt_jetpack.data.remote.ApiHelper
import com.kyawlinnthant.klt_jetpack.model.api.ResponseNews
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface DataManager : ApiHelper, DbHelper {

    fun requestNews(page: Int, category : String): Deferred<Response<ResponseNews>>
}