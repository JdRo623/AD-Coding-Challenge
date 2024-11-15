package com.joanDuarte.admobiletest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class ArticleApp : Application(){
    val applicationScope = CoroutineScope(SupervisorJob())
}