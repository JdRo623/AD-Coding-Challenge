package com.joanDuarte.admobiletest.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joanDuarte.admobiletest.domain.article.ArticleRepository
import com.joanDuarte.admobiletest.presentation.model.ArticleUi
import com.joanDuarte.admobiletest.presentation.model.toArticle
import com.joanDuarte.admobiletest.presentation.model.toArticleUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
): ViewModel() {

   // private val mutableStateList = mutableStateListOf(Article())
    val state = mutableStateOf(ArticleListScreenState())

    init {
        getArticles()
    }

    fun deleteArticle(articleUi: ArticleUi){
        val articles = state.value.articles
        articles.map {
            if(it==articleUi) it.deleted = true
        }
        state.value = state.value.copy(articles = articles)
        viewModelScope.launch{
            articleRepository.deleteArticle(articleUi.toArticle())
        }
    }
    fun getArticles(){
        viewModelScope.launch {
            state.value = state.value.copy(isRefreshing = true)
            articleRepository.getArticles().collect{
                state.value = state.value.copy(articles = it.map { article -> article.toArticleUI() }, isRefreshing = false)
            }
        }
    }
}