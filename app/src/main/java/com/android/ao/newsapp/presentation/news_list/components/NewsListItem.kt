package com.android.ao.newsapp.presentation.news_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.ao.newsapp.data.model.News

/**
 * @author alper
 * Created 26.07.2022
 */
@Composable
fun NewsListItem(
    news: News,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick() }
    ) {
        NewsImageItem(news.urlToImage)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
        ) {
            Text(
                text = news.title,
                color = MaterialTheme.colors.surface,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 40.dp
                    ),
                style = MaterialTheme.typography.h6.copy(
                    fontSize = 24.sp
                ),
            )
            Text(
                text = news.source.name,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = 24.dp,
                        bottom = 6.dp
                    ),
                style = MaterialTheme.typography.h6.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic
                )
            )
        }
    }
}