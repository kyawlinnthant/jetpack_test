package com.kyawlinnthant.klt_jetpack.ui

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kyawlinnthant.klt_jetpack.R
import com.kyawlinnthant.klt_jetpack.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainNavigator {
    override fun setupNavigation() {
        //get host and controller
        val host = supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        val controller = host.navController
        //set graph
        appBarConfiguration = AppBarConfiguration(controller.graph)
        //set appbar
        appBarConfiguration = AppBarConfiguration(setOf(R.id.bottom_sport,R.id.bottom_technology))
        //set appbar
        setupActionBarWithNavController(controller, appBarConfiguration)
        //set bottom nav
        home_bottom_nav.setupWithNavController(controller)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun observe() {

    }

    override fun initUi() {

        setupNavigation()
    }




}
