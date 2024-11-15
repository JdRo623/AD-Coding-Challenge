package com.joanDuarte.admobiletest.domain.model

import com.joanDuarte.admobiletest.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface LocalArticleDataSource {
    suspend fun getArticles(): List<Article>
    suspend fun getDeletedArticles(): List<Article>
    suspend fun saveArticles(articles: List<Article>)
    suspend fun deleteArticles(article: Article)
}