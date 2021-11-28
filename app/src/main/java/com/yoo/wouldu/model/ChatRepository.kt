package com.yoo.wouldu.model

import com.yoo.wouldu.model.data.chat.Chat
import com.yoo.wouldu.model.data.chat.ChatPreview
import java.time.LocalDateTime

class ChatRepository {

    // 테스트용 더미
    val dummy =
        listOf(
            ChatPreview("", "티티코", "네~ 좋은 하루보내세요!", LocalDateTime.of(2021, 11, 27, 17, 10), "2"),
            ChatPreview("", "잼잼", "SK텔레콤관앞에 도착했습니다. 내려와주세요~", LocalDateTime.of(2021, 11, 27, 16, 56), "3"),
            ChatPreview("", "햄찌", "잘 드세요~~!!", LocalDateTime.of(2021, 11, 27, 15, 10), "1"),
            )

    val dummyWhole =
        listOf(
            Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "하이하이루", null),
            Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "하이하이루", null),
            Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "하이하이루", null),
            Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "하이하이루", null),
            Chat("", LocalDateTime.of(2021, 11, 2, 16, 31), false, "하이하이루", null)
        )
}