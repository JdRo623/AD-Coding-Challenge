package com.joanDuarte.admobiletest.presentation.components

import android.view.ViewGroup
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.joanDuarte.admobiletest.presentation.model.ArticleUi

@Composable
fun WebViewComponent(
    modifier: Modifier = Modifier,
    articleUi: ArticleUi?
){
    articleUi?.let {
        val url = remember {
            mutableStateOf(it.url)
        }
        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }, update = {
            it.loadUrl(url.value)
        })
    }
}