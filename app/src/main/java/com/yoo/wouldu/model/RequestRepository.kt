package com.yoo.wouldu.model

import com.yoo.wouldu.model.data.request.How
import com.yoo.wouldu.model.data.request.Pay
import com.yoo.wouldu.model.data.request.Request
import com.yoo.wouldu.model.data.request.Status
import java.time.LocalDateTime

class RequestRepository {
    // 테스트용 더미
    val dummy =
        listOf(
            Request("1", "재무관리 2과 프린트", How.DO, "신세계관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "지지고 참치마요", How.BUY, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "맥북 충전기 C타입", How.LEND, "100주년 기념관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "사물함 대리수령", How.DO, "중앙도서관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "회귀분석 수업시간에 포스트잇", How.BUY, "경영대", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "기숙사 택배 대신 수령", How.DO, "기숙사 A동", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "시험봐야하는데 공학계산기", How.LEND, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "재무관리 2과 프린트", How.DO, "신세계관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "지지고 참치마요", How.BUY, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "맥북 충전기 C타입", How.LEND, "100주년 기념관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "사물함 대리수령", How.DO, "중앙도서관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "회귀분석 수업시간에 포스트잇", How.BUY, "경영대", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "기숙사 택배 대신 수령", How.DO, "기숙사 A동", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE),
            Request("1", "시험봐야하는데 공학계산기", How.LEND, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "", "", "이니마니모", LocalDateTime.of(2021, 3, 1, 12, 0), Status.ACTIVE)
        )

    // 전체

    // 해주세요

    // 사다주세요

    // 빌려주세요

}