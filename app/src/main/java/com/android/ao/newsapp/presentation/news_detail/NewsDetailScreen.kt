package com.android.ao.newsapp.presentation.news_detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import com.android.ao.newsapp.R
import com.android.ao.newsapp.data.model.News
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

/**
 * @author alper
 * Created 26.07.2022
 */
@Composable
fun NewsDetailScreen(
    news: News,
    viewModel: NewsDetailViewModel = hiltViewModel()
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Card(elevation = 8.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            backgroundColor = Color.White) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(6.dp)
                ) {
                    Text(
                        text = news.title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                    )
                    CoilImage(
                        imageModel = news.urlToImage,
                        imageLoader = {
                            ImageLoader.Builder(LocalContext.current)
                                .availableMemoryPercentage(0.25)
                                .build()
                        },
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.height(250.dp).fillMaxWidth().padding(
                            top = 8.dp
                        ),
                        shimmerParams = ShimmerParams(
                            baseColor = MaterialTheme.colors.background,
                            highlightColor = MaterialTheme.colors.onSurface,
                            durationMillis = 500,
                            dropOff = 0.65f,
                            tilt = 20f
                        ),
                        error = ImageBitmap.imageResource(R.drawable.placeholder)
                    )
                    news.author?.let {
                        Text(
                            text = it,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .padding(top = 6.dp),
                            fontSize = 16.sp,
                        )
                    }
                    Text(
                        text = viewModel.parsePublishDate(news.publishedAt),
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(top = 6.dp),
                        fontSize = 16.sp,
                    )
                }
            }
            Text(
                text = news.description,
                color = MaterialTheme.colors.primaryVariant,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                fontSize = 22.sp,
            )
            news.content?.let {
                Text(
                    text = viewModel.clearContent(it),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                    fontSize = 22.sp,
                )
            }
            Text(
                color = Color.Blue,
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    .clickable {
                        viewModel.openNewsWebsite(news.url)
                    },
                text = "Read more on ${news.source.name} website",
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic
            )
        }
}