package com.kyawlinnthant.klt_jetpack.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun observe()
    abstract fun initUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        initUi()
        observe()

    }
}