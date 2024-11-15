package com.joanDuarte.admobiletest.presentation

import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.presentation.components.ArticleItem
import com.joanDuarte.admobiletest.presentation.components.PullToRefreshLazyColumn
import com.joanDuarte.admobiletest.presentation.components.SwipeToDeleteContainer
import com.joanDuarte.admobiletest.presentation.model.ArticleUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ArticleListScreen(
    state: MutableState<ArticleListScreenState>,
    onRefresh: () -> Unit,
    onClickItem: (ArticleUi)-> Unit,
    onDeleteItem: (ArticleUi)-> Unit
){
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        PullToRefreshLazyColumn(
            items = state.value.articles,
            content = { article ->
                if(!article.deleted){
                    SwipeToDeleteContainer(
                        item = article,
                        onDelete = {onDeleteItem(it)}
                    ){
                        ArticleItem(
                            modifier = Modifier.clickable(
                                onClick = {onClickItem(it)}
                            ),
                            article = it)
                    }
                }
            },
            isRefreshing = state.value.isRefreshing,
            onRefresh = {
                onRefresh()
            }
        )

    }
}