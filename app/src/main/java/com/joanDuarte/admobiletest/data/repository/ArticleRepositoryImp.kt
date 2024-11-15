package com.joanDuarte.admobiletest.data.repository

import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.domain.article.LocalArticleDataSource
import com.joanDuarte.admobiletest.domain.article.RemoteArticleDataSource
import com.joanDuarte.admobiletest.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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

        localArticleDataSource.getDeletedArticles().let{ deletedList ->
            clearList = clearList.filter{ article
                -> deletedList.find { it.id == article.id } == null
            }
        }

        emit(clearList)
    }

    override suspend fun deleteArticle(article: Article) {
        localArticleDataSource.deleteArticles(article)
    }
}