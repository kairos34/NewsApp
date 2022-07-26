package com.android.ao.newsapp.presentation.news_detail

import androidx.lifecycle.ViewModel
import com.android.ao.newsapp.domain.usecases.ParsePublishDate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author alper
 * Created 26.07.2022
 */
@HiltViewModel
class NewsDetailViewModel @Inject constructor(
 private val parsePublishDate: ParsePublishDate
): ViewModel() {
    fun parsePublishDate(date: String): String = parsePublishDate.invoke(date)
}