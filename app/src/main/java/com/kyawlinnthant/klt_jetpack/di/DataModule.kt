package com.kyawlinnthant.klt_jetpack.di

import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kyawlinnthant.klt_jetpack.app.AppConstants
import com.kyawlinnthant.klt_jetpack.data.AppDataManager
import com.kyawlinnthant.klt_jetpack.data.DataManager
import com.kyawlinnthant.klt_jetpack.data.local.db.AppDbHelper
import com.kyawlinnthant.klt_jetpack.data.local.db.DbHelper
import com.kyawlinnthant.klt_jetpack.data.remote.ApiHelper
import com.kyawlinnthant.pagingtest.data.db.room.NewsDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    single { getClient() }
    single { getApiService<ApiHelper>(get()) }
    single { AppDataManager(get(), get()) as DataManager }
    single { AppDbHelper(getDatabase(androidContext(), "news")) as DbHelper }
}

fun getClient() = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

inline fun <reified T> getApiService(client: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.API_END_POINT)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    return retrofit.create(T::class.java)
}

fun getDatabase(context: Context, name: String) = Room.databaseBuilder(context, NewsDatabase::class.java, name).build()