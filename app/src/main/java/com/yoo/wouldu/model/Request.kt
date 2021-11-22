package com.yoo.wouldu.model

import java.util.*

data class Request(
    var what: String,
    var how: How,
    var where: String,
    var whereDetail: String?,
    var date: Date,
    var pay: Pay,
    var message: String?
)
