package com.example.todaysweather


import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.home.Common
import com.example.todaysweather.databinding.ActivityMainBinding
import com.example.todaysweather.factory.TodaysWeatherFragmentFactory
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yangbong.core_ui.base.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = TodaysWeatherFragmentFactory(this)
        super.onCreate(savedInstanceState)
        val permissionList = arrayOf<String>(
            // 위치 권한
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )
        ActivityCompat.requestPermissions(this@MainActivity, permissionList, 1)
//        initTransactionToHome()
//        syncBottomNavWithNavController()
    }

//
//    private fun syncBottomNavWithNavController() {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        findViewById<BottomNavigationView>(R.id.bottom_nav)
//            .setupWithNavController(navController)
//    }
//
//    private fun initTransactionToHome() {
//        transactionToHome = {
//            findViewById<BottomNavigationView>(R.id.bottom_nav)
//
//        }
//    }

    companion object {
        lateinit var transactionToHome: () -> Unit
    }


}