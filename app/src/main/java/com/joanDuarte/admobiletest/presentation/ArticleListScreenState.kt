package com.joanDuarte.admobiletest.presentation

import com.joanDuarte.admobiletest.presentation.model.ArticleUi


data class ArticleListScreenState(
    val articles: List<ArticleUi> = emptyList(),
    val isRefreshing: Boolean = false
)
