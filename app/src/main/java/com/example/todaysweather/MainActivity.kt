package com.example.todaysweather


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.todaysweather.databinding.ActivityMainBinding
import com.example.todaysweather.factory.TodaysWeatherFragmentFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yangbong.core_ui.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = TodaysWeatherFragmentFactory(this)
        super.onCreate(savedInstanceState)
        initTransactionToHome()
        syncBottomNavWithNavController()
    }


    private fun syncBottomNavWithNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            .setupWithNavController(navController)
    }

    private fun initTransactionToHome() {
        transactionToHome = {
            findViewById<BottomNavigationView>(R.id.bottom_nav)
                
        }
    }

    companion object {
        lateinit var transactionToHome: () -> Unit
    }


}