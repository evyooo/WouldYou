package com.yoo.wouldu.model.data

import java.util.*

data class Request(
    val id: String,
    var what: String,
    var how: How,
    var where: String,
    var whereDetail: String?,
    var date: Date,
    var pay: Pay,
    var message: String?
)
