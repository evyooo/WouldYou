package com.yoo.wouldu.model.data.chat

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class ChatPreview(
    var chatId: String,
    var username: String,
    var latestMsg: String,
    var time: LocalDateTime,
    var count: String
): Parcelable