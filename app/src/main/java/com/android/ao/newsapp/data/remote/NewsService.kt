package com.android.ao.newsapp.data.remote

import com.android.ao.newsapp.data.model.NewsHeadlines
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author alper
 * Created 25.07.2022
 */
interface NewsService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("q") query: String
    ): NewsHeadlines
}