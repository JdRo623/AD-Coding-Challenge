package com.joanDuarte.admobiletest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.presentation.components.WebViewComponent
import com.joanDuarte.admobiletest.presentation.model.ArticleUi
import com.joanDuarte.admobiletest.theme.AdMobileTest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AdMobileTest {
                // A surface container using the 'background' color from the theme
                var showWebView by remember {
                    mutableStateOf(false)
                }
                var selectedArticleUi: ArticleUi? = null

                BackHandler {
                    showWebView = false
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = remember {viewModel.state}
                    ArticleListScreen(
                        state = state,
                        onRefresh = {
                            viewModel.getArticles()
                        },
                        onClickItem = {
                            showWebView = true
                            selectedArticleUi = it
                        },
                        onDeleteItem = {
                            viewModel.deleteArticle(it)
                        })
                    if(showWebView)
                        WebViewComponent(articleUi = selectedArticleUi)
                }
            }
        }
    }
}

