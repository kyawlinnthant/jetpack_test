package com.kyawlinnthant.klt_jetpack.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.kyawlinnthant.klt_jetpack.data.DataManager
import com.kyawlinnthant.klt_jetpack.model.db.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NewsDataSource(
    private val job: Job,
    private val dataManager: DataManager,
    private val category: String
) : PageKeyedDataSource<Int, News>(), CoroutineScope {

    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO
    private var PAGE = 1

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, News>) {
        launch {
            try {
                val result = dataManager.requestNews(PAGE,category).await()
                if (result.isSuccessful){
                    callback.onResult(result.body()?.articles!!,null,PAGE+1)
                }else{
                    Log.e(this@NewsDataSource::class.java.simpleName,result.errorBody().toString())
                }
            }
            catch (e: Exception){
                Log.e(this@NewsDataSource::class.java.simpleName,e.toString())
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {

        launch {
            try {
                val result = dataManager.requestNews(PAGE,category).await()
                if (result.isSuccessful){
                    callback.onResult(result.body()?.articles!!,params.key+1)
                }else{
                    Log.e(this@NewsDataSource::class.java.simpleName,result.errorBody().toString())
                }
            }
            catch (e: Exception){
                Log.e(this@NewsDataSource::class.java.simpleName,e.toString())
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {

    }
}