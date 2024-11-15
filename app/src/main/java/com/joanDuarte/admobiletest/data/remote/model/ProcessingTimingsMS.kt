package com.joanDuarte.admobiletest.data.remote.model

data class ProcessingTimingsMS(
    val _request: Request,
    val afterFetch: AfterFetch,
    val fetch: Fetch,
    val getIdx: GetIdx,
    val total: Int
)