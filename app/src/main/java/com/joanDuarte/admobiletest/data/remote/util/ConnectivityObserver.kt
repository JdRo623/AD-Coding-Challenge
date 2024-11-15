package com.joanDuarte.admobiletest.data.remote.util

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Status

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}