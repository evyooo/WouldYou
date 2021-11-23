package com.yoo.wouldu.model.data

import java.time.LocalDateTime

data class Request(
    val id: String,
    var what: String,
    var how: How,
    var where: String,
    var whereDetail: String?,
    var date: LocalDateTime,
    var pay: Pay,
    var message: String?
)
