package com.android.ao.newsapp.presentation.news_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.*

/**
 * @author alper
 * Created 27.07.2022
 */
@Composable
fun CategorySelectionScreen(
    selectedCategory: State<String>,
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
                ),
                colors = ButtonDefaults.buttonColors(backgroundColor =
                if (selectedCategory.value == category) {
                    Color.Yellow
                } else {
                    MaterialTheme.colors.primary
                })
            ) {
                Text(category.uppercase(Locale("en", "US")))
            }
        }
    }
}