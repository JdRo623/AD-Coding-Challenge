package com.joanDuarte.admobiletest.presentation.model

import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.presentation.util.DateFormatter

fun Article.toArticleUI():ArticleUi{
    return ArticleUi(
        id = id,
        title = title,
        author = author,
        creationDistance = DateFormatter(createdAt).invoke(),
        createdAt = createdAt,
        url = url,
        deleted = false
    )
}

fun ArticleUi.toArticle():Article{
    return Article(
        id = id,
        title = title,
        author = author,
        createdAt = createdAt,
        url = url
    )
}