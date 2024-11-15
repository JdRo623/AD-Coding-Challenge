package com.joanDuarte.admobiletest.data.remote.dataSource

import com.joanDuarte.admobiletest.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface RemoteArticleDataSource {
    suspend fun getArticles(): List<Article>?
}