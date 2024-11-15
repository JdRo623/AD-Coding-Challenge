package com.joanDuarte.admobiletest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joanDuarte.admobiletest.domain.model.Article
import com.joanDuarte.admobiletest.theme.AdMobileTest

@Composable
fun ArticleItem (
    article: Article,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier
        .background(color = Color.White)
        ){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Row (modifier = Modifier){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    text = article.title)
            }
            Row (modifier = Modifier){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    text = article.author)
            }
            Row (modifier = Modifier){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    text = article.createdAt)
            }
        }
        HorizontalDivider(modifier = modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleItemPreview() {
    AdMobileTest {
        ArticleItem(
            Article(
                "id",
                " Title",
                " Author",
                "12aM",
                ""
            )
        )
    }
}