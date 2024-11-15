package com.joanDuarte.admobiletest.data.repository

import com.joanDuarte.admobiletest.data.local.toArticle
import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.domain.model.LocalArticleDataSource
import com.joanDuarte.admobiletest.data.remote.dataSource.RemoteArticleDataSource
import com.joanDuarte.admobiletest.data.remote.util.ConnectivityObserver
import com.joanDuarte.admobiletest.domain.model.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.lang.Exception
import java.net.UnknownHostException

class ArticleRepositoryImp(
    private val remoteArticleDataSource: RemoteArticleDataSource,
    private val localArticleDataSource: LocalArticleDataSource
): ArticleRepository {

    override suspend fun getArticles(): Flow<List<Article>> = flow{
        var clearList = remoteArticleDataSource.getArticles()?.let {
            localArticleDataSource.saveArticles(it)
            it
        }?:run{
            localArticleDataSource.getArticles()
        }

        localArticleDataSource.getDeletedArticles().let{localList ->
            clearList = clearList.filterNot{localList.contains(it)}
        }

        emit(clearList)
    }

    override suspend fun deleteArticle(article: Article) {
        localArticleDataSource.deleteArticles(article)
    }
}