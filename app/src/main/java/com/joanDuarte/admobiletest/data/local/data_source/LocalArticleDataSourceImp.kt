package com.joanDuarte.admobiletest.data.local.data_source

import com.joanDuarte.admobiletest.data.local.toArticle
import com.joanDuarte.admobiletest.data.local.toSavedArticle
import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.domain.model.LocalArticleDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalArticleDataSourceImp(
    private val articleDao: ArticleDao,
    private val applicationScope: CoroutineScope
    ): LocalArticleDataSource {
    override suspend fun getArticles(): List<Article> {
        return applicationScope.async {
            articleDao.getArticles().map { it.toArticle() }
        }.await()
    }

    override suspend fun saveArticles(articles: List<Article>) {
        val savedArticles = articles.map {
            it.toSavedArticle()
        }
       articleDao.insertAllArticles(
            savedArticles
        )
    }

    override suspend fun getDeletedArticles(): List<Article> {
        return applicationScope.async {
            articleDao.getArticles().filter { it.deleted }.map {savedArticle ->
                savedArticle.toArticle()  }
        }.await()
    }

    override suspend fun deleteArticles(article: Article) {
        val deletedArticle = article.toSavedArticle()
        deletedArticle.deleted = true
        articleDao.updateArticle(deletedArticle)
    }
}