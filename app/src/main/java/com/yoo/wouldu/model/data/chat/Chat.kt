package com.yoo.wouldu.model.data.chat

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class Chat(
    var chatId: String,
    var dateTime: LocalDateTime,
    var isRight: Boolean,
    var message: String?,
    var image: String?
): Parcelable
