package com.joanDuarte.admobiletest.data.remote.dataSource


import com.joanDuarte.admobiletest.data.remote.toArticle
import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.domain.article.RemoteArticleDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import java.net.UnknownHostException

class RemoteArticleDataSourceImp(
    private val articleService: ArticleService,
    private val applicationScope: CoroutineScope
    ): RemoteArticleDataSource {
    override suspend fun getArticles(): List<Article>?{
        return applicationScope.async {
            try {
                articleService.getArticles().toArticle()
            }catch (e: UnknownHostException){
                null
            }
        }.await()
    }
}