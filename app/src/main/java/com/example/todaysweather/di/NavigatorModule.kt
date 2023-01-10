package com.example.todaysweather.di

import com.example.navigator.MainNavigator
import com.example.todaysweather.navigator.MainNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class NavigatorModule {
    @Binds
    abstract fun provideMainNavigator(
        navigator: MainNavigatorImpl
    ): MainNavigator
}
