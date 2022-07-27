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

    companion object {
        private const val DEFAULT_CATEGORY = "general"
    }

    private var selectedCategory = DEFAULT_CATEGORY

    init {
        refresh(userSettings.country)
        listenCountry()
    }

    private fun listenCountry() {
        userSettings.countryStream.onEach { country ->
            refresh(country)
        }.launchIn(viewModelScope)
    }

    fun refresh(country: String? = null, category: String? = null) {
        getNewsListUseCase(setAndGetCategory(category), country ?: userSettings.country).onEach { newsListResult ->
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
            selectedCategory = this
        } ?: selectedCategory
}