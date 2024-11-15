package com.joanDuarte.admobiletest.domain.model

import com.joanDuarte.admobiletest.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getArticles(): Flow<List<Article>>
    suspend fun deleteArticle( article: Article)

}