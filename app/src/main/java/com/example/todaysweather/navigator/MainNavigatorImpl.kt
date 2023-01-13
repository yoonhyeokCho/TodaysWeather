package com.example.todaysweather.navigator

import android.content.Context
import com.example.navigator.MainNavigator
import com.example.todaysweather.MainActivity
import com.yangbong.core_ui.extension.navigateActivity
import javax.inject.Inject

internal class MainNavigatorImpl @Inject constructor() : MainNavigator{
    override fun navigateMain(context: Context) {
        context.navigateActivity<MainActivity>()
    }

    override fun transactionToHome() {
        MainActivity.transactionToHome()
    }
}