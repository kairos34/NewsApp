package com.android.ao.newsapp.domain.repository

import com.android.ao.newsapp.data.model.NewsHeadlines

/**
 * @author alper
 * Created 25.07.2022
 */
interface NewsRepository {
    suspend fun getNews(
        country: String = "us",
        category: String,
        query: String
    ): NewsHeadlines
}