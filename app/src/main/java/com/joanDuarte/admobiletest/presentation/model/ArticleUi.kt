package com.joanDuarte.admobiletest.presentation.model

import com.joanDuarte.admobiletest.presentation.util.DateFormatter

data class ArticleUi (
    val id: String,
    val title: String,
    val author: String,
    val createdAt: String,
    val creationDistance: String,
    val url: String,
    var deleted: Boolean = false
)