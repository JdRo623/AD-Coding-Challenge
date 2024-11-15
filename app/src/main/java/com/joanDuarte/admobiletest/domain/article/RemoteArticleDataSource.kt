package com.joanDuarte.admobiletest.domain.article

import com.joanDuarte.admobiletest.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface RemoteArticleDataSource {
    suspend fun getArticles(): List<Article>?
}