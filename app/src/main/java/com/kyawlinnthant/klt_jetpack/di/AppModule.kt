package com.kyawlinnthant.klt_jetpack.di

import com.kyawlinnthant.klt_jetpack.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}