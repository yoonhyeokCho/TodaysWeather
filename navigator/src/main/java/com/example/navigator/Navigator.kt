package com.example.navigator

import android.content.Context

interface MainNavigator{
    // MainActivity로 이동
    fun navigateMain(context: Context)
    
    /** MainActivity로 이동시 home화면이 나오도록 transaction 하는 로직 */
    fun transactionToHome()
}