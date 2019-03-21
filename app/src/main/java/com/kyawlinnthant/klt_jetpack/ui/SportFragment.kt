package com.kyawlinnthant.klt_jetpack.ui

import android.widget.Toast
import com.kyawlinnthant.klt_jetpack.R
import com.kyawlinnthant.klt_jetpack.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SportFragment : BaseFragment() {

    private val vm: MainViewModel by viewModel()
    override val layoutId: Int get() = R.layout.fragment_sport

    override fun observe() {

    }

    override fun initUi() {

        Toast.makeText(context,"Sport", Toast.LENGTH_LONG).show()
    }
}