package com.android.ao.newsapp.di

import com.android.ao.newsapp.data.remote.NewsService
import com.android.ao.newsapp.data.repository.NewsRepositoryImpl
import com.android.ao.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author alper
 * Created 25.07.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(service: NewsService): NewsRepository {
        return NewsRepositoryImpl(service)
    }

}