package com.android.ao.newsapp.presentation.splash.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.ao.newsapp.R


/**
 * @author alper
 * Created 27.07.2022
 */
@Composable
fun AppDeveloperItem() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()) {
        Image(
            modifier = Modifier.padding(40.dp),
            painter = painterResource(id = R.drawable.developer),
            contentDescription = null
        )
        val fontFamily = FontFamily(
            Font(R.font.corben_bold, FontWeight.Bold)
        )
        Text(
            text = "Alper Özaslan",
            fontFamily = fontFamily,
            modifier = Modifier.padding(20.dp),
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        )
    }
}