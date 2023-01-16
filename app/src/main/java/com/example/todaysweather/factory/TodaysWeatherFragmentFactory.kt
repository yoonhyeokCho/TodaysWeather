package com.example.todaysweather.factory

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.core_ui.util.Injector
import com.example.core_ui.util.ResolutionMetrics
import com.example.home.HomeFragment
import dagger.hilt.android.EntryPointAccessors

class TodaysWeatherFragmentFactory(activity: AppCompatActivity) : FragmentFactory() {

    private val resolutionMetrics: ResolutionMetrics by lazy {
        EntryPointAccessors.fromActivity(
            activity,
            Injector.ResolutionMetricsInjector::class.java
        ).resolutionMetrics()
    }

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            HomeFragment::class.java.name -> HomeFragment(resolutionMetrics)
            else -> super.instantiate(classLoader, className)
        }


    }
}