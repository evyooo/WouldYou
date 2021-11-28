package com.yoo.wouldu.model

import com.yoo.wouldu.model.data.chat.Chat
import com.yoo.wouldu.model.data.chat.ChatPreview
import java.time.LocalDateTime

class ChatRepository {

    // 테스트용 더미
    val dummy =
        listOf(
            ChatPreview("0", "티티코", "네~ 좋은 하루보내세요!", LocalDateTime.of(2021, 11, 27, 17, 10), "2"),
            ChatPreview(
                "1",
                "잼잼",
                "SK텔레콤관앞에 도착했습니다. 내려와주세요~",
                LocalDateTime.of(2021, 11, 27, 16, 56),
                "3"
            ),
            ChatPreview("2", "햄찌", "잘 드세요~~!!", LocalDateTime.of(2021, 11, 27, 15, 10), "1"),
        )

    val dummyList =
        arrayOf(
            listOf(
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "안녕하세요", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "정문에서 내일 4시 45분까지 만날 수 있나요?", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "네! 가능해요", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "내일 그럼 정문에서 뵙겠습니다.", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 16, 31), false, "하이하이루", null)
            ),
            listOf(
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "하이하이루", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "하이하이루", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "하이하이루", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "하이하이루", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 16, 31), false, "하이하이루", null)
            ),
            listOf(
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "안녕하세요!", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "제가 바로 비대면 수업이라서 정신이 없어서\n이렇게 부탁드리네요ㅜㅜ  ", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "아닙니다", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 15, 0), true, "일단 공차 나중에 사고 연락드릴게요!", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 16, 31),true, "방금 샀어요~ 한 20분에 신공학관에 도착할\n것 같습니다.", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), false, "네! 계좌주시면 바로 보내드릴게요!", null),
                Chat("", LocalDateTime.of(2021, 11, 2, 14, 56), true, "신한 112-2929-0003 ㅇㅇㅎ 입니다. ", null)

                )
        )

    val dummyEmpty =
        listOf<Chat>()
}