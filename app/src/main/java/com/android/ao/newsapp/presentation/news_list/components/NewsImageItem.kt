package com.android.ao.newsapp.presentation.news_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import coil.ImageLoader
import com.android.ao.newsapp.R
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

/**
 * @author alper
 * Created 26.07.2022
 */
@Composable
fun NewsImageItem(imageUrl: String?) {
    CoilImage(
        imageModel = imageUrl,
        imageLoader = {
            ImageLoader.Builder(LocalContext.current)
                .availableMemoryPercentage(0.25)
                .build()
        },
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = MaterialTheme.colors.onSurface,
            durationMillis = 500,
            dropOff = 0.65f,
            tilt = 20f
        ),
        error = ImageBitmap.imageResource(R.drawable.placeholder)
    )
}