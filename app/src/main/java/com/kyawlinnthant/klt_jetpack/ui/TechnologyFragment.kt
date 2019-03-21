package com.kyawlinnthant.klt_jetpack.ui

import android.widget.Toast
import com.kyawlinnthant.klt_jetpack.R
import com.kyawlinnthant.klt_jetpack.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TechnologyFragment : BaseFragment() {

    private val vm: MainViewModel by viewModel()
    override val layoutId: Int get() = R.layout.fragment_technology

    override fun observe() {

    }

    override fun initUi() {
        Toast.makeText(context,"Techno",Toast.LENGTH_LONG).show()
    }
}