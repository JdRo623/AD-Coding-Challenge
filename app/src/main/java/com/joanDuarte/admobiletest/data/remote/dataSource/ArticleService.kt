package com.joanDuarte.admobiletest.data.remote.dataSource

import com.joanDuarte.admobiletest.data.remote.model.ArticleServerResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ArticleService {
    @GET("search_by_date?query=mobile")
    suspend fun getArticles(): ArticleServerResponse

}