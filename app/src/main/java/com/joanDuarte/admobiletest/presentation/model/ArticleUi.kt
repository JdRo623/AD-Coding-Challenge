package com.joanDuarte.admobiletest.presentation.model

data class ArticleUi (
    val id: String,
    val title: String,
    val author: String,
    val createdAt: String,
    val url: String,
    var deleted: Boolean = false
){
    val creationDistance: String
        get() = createdAt
}