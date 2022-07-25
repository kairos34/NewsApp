package com.android.ao.newsapp.di

import com.android.ao.newsapp.BuildConfig
import com.android.ao.newsapp.common.Constants.BASE_URL
import com.android.ao.newsapp.common.Constants.PARAM_API_KEY
import com.android.ao.newsapp.data.remote.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author alper
 * Created 25.07.2022
 */
@Module
@InstallIn
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().url(
                    chain.request().url.newBuilder()
                        .addQueryParameter(PARAM_API_KEY, BuildConfig.API_KEY)
                        .build()
                ).build()
            )
        }
    }

    @Provides
    @Singleton
    fun provideClient(apiKeyInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsService(client: OkHttpClient): NewsService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsService::class.java)
}