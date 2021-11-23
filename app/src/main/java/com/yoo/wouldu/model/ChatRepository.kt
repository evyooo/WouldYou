package com.yoo.wouldu.model

import com.yoo.wouldu.model.data.chat.ChatPreview
import java.time.LocalDateTime

class ChatRepository {

    // 테스트용 더미
    val dummy =
        listOf(
            ChatPreview("", "이니마니모", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "2"),
            ChatPreview("", "가가가르디", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "3"),
            ChatPreview("", "유", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "1"),
            ChatPreview("", "도키", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "1"),
            ChatPreview("", "닉네임1", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "0"),
            ChatPreview("", "닉네임2", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "0"),
            ChatPreview("", "닉네임3", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "0"),
            ChatPreview("", "닉네임4", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "0"),
            ChatPreview("", "닉네임5", "네네 괜찮아요!! 감사합니다.", LocalDateTime.of(2021, 3, 1, 12, 30), "0")
        )
}