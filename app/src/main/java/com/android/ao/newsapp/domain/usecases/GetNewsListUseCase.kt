package com.android.ao.newsapp.domain.usecases

import com.android.ao.newsapp.common.Resource
import com.android.ao.newsapp.data.model.News
import com.android.ao.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @author alper
 * Created 25.07.2022
 */
class GetNewsListUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(
        category: String,
        country: String,
        query: String
    ): Flow<Resource<List<News>>> = flow {
        try {
            emit(Resource.Loading())
            val newsList = repository.getNews(
                country = country,
                category = category,
                query = query
            ).news
            emit(Resource.Success(newsList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}