package com.android.ao.newsapp.presentation.news_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.ao.newsapp.common.Resource
import com.android.ao.newsapp.domain.usecases.GetNewsListUseCase
import com.android.ao.newsapp.preferences.UserSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * @author alper
 * Created 26.07.2022
 */
@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase,
    private val userSettings: UserSettings
) : ViewModel() {

    private val _newsListState = MutableStateFlow(NewsListState())
    val newsListState: StateFlow<NewsListState> = _newsListState.asStateFlow()

    private val _categoryState = MutableStateFlow("general")
    val categoryState: StateFlow<String> = _categoryState.asStateFlow()

    private val _queryState = MutableStateFlow("")
    val queryState: StateFlow<String> = _queryState.asStateFlow()

    init {
        refresh(userSettings.country)
        listenCountry()
    }

    private fun listenCountry() {
        userSettings.countryStream.onEach { country ->
            refresh(country)
        }.launchIn(viewModelScope)
    }

    fun refresh(country: String? = null, category: String? = null, query: String? = null) {
        getNewsListUseCase(
            setAndGetCategory(category),
            country ?: userSettings.country,
            setAndGetQuery(query)
        ).onEach { newsListResult ->
            when (newsListResult) {
                is Resource.Success -> {
                    _newsListState.value = NewsListState(
                        news = newsListResult.data
                    )
                }
                is Resource.Error -> {
                    _newsListState.value = NewsListState(
                        error = newsListResult.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _newsListState.value = NewsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun setAndGetCategory(category: String?) =
        category?.apply {
            _categoryState.value = this
        } ?: _categoryState.value

    private fun setAndGetQuery(query: String?) =
        query?.apply {
            _queryState.value = this
        } ?: _queryState.value
}