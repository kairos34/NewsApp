package com.android.ao.newsapp.presentation.splash.components

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.android.ao.newsapp.R

/**
 * @author alper
 * Created 27.07.2022
 */
@Composable
fun AppLogoItem(navigateToNewsList: () -> Unit) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.6f,
            animationSpec = tween(
                durationMillis = 4000,
                delayMillis = 100,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        navigateToNewsList.invoke()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .scale(scale.value)
        )
    }
}