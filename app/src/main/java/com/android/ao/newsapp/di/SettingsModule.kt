package com.android.ao.newsapp.di

import com.android.ao.newsapp.preferences.UserSettings
import com.android.ao.newsapp.preferences.UserSettingsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author alper
 * Created 26.07.2022
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {
    @Binds
    @Singleton
    abstract fun bindUserSettings(
        userSettingsImpl: UserSettingsImpl
    ): UserSettings
}