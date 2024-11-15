package com.joanDuarte.admobiletest.data.remote.dataSource


import com.joanDuarte.admobiletest.data.local.toArticle
import com.joanDuarte.admobiletest.data.remote.toArticle
import com.joanDuarte.admobiletest.domain.model.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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