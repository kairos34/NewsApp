package com.android.ao.newsapp.presentation.news_detail

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import com.android.ao.newsapp.domain.usecases.ParsePublishDate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author alper
 * Created 26.07.2022
 */
@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val context: Application,
    private val parsePublishDate: ParsePublishDate
): AndroidViewModel(context) {
    fun parsePublishDate(date: String): String = parsePublishDate.invoke(date)

    fun openNewsWebsite(url: String) {
        context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
        )
    }

    fun clearContent(content: String) = content.substring(0, content.lastIndexOf("[+"))
}