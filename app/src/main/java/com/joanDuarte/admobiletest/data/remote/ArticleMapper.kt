package com.joanDuarte.admobiletest.data.remote

import com.joanDuarte.admobiletest.data.remote.model.ArticleServerResponse
import com.joanDuarte.admobiletest.domain.model.Article

fun ArticleServerResponse.toArticle(): List<Article>{
    return hits.map {
        Article(
            id= it.objectID,
            title = it.title ?: it.story_title ?: "",
            author = it.author,
            createdAt = it.created_at,
            url = it.story_url ?: ""
        )
    }
}