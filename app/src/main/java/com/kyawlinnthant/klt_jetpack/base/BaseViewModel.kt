package com.kyawlinnthant.klt_jetpack.base

import androidx.lifecycle.ViewModel
import com.kyawlinnthant.klt_jetpack.data.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(val dataManager: DataManager) : ViewModel(), CoroutineScope {

    protected val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override fun onCleared() {
        super.onCleared()
        job.cancelChildren()
    }

}