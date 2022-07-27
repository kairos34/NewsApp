package com.android.ao.newsapp.presentation.news_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import java.util.*

/**
 * @author alper
 * Created 27.07.2022
 */
@Composable
fun CategorySelectionScreen(
    onCategorySelected: (String) -> Unit
) {
    val categories = listOf(
        "general",
        "business",
        "entertainment",
        "health",
        "science",
        "sports",
        "technology"
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = rememberLazyListState()
    ) {
        items(categories) { category ->
            Button(
                onClick = { onCategorySelected(category) },
                modifier = Modifier.padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
            ) {
                Text(category.uppercase(Locale("en", "US")))
            }
        }
    }
}