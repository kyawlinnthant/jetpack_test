package com.kyawlinnthant.klt_jetpack.data

import com.kyawlinnthant.klt_jetpack.app.AppConstants
import com.kyawlinnthant.klt_jetpack.data.local.db.DbHelper
import com.kyawlinnthant.klt_jetpack.data.remote.ApiHelper
import com.kyawlinnthant.klt_jetpack.model.api.ResponseNews
import kotlinx.coroutines.Deferred
import retrofit2.Response

open class AppDataManager(
    private val apiHelper: ApiHelper,
    private val dbHelper: DbHelper
) : DataManager, ApiHelper by apiHelper, DbHelper by dbHelper{


    override fun requestNews(page: Int, category: String): Deferred<Response<ResponseNews>> = getData(AppConstants.API_KEY,category,page)
}