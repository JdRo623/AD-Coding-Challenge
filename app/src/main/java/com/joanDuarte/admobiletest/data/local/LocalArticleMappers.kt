package com.joanDuarte.admobiletest.data.local

import com.joanDuarte.admobiletest.data.local.model.SavedArticle
import com.joanDuarte.admobiletest.domain.model.Article

fun SavedArticle.toArticle(): Article{
    return Article(
        id = id,
        title = title,
        author = author,
        createdAt = createdAt,
        url = url
    )
}

fun Article.toSavedArticle(): SavedArticle{
    return SavedArticle(
        id = id,
        title = title,
        author = author,
        createdAt = createdAt,
        url = url,
        deleted = false
    )
}