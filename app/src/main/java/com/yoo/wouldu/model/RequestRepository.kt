package com.yoo.wouldu.model

import com.yoo.wouldu.model.data.How
import com.yoo.wouldu.model.data.Pay
import com.yoo.wouldu.model.data.Request
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDateTime
import java.util.*

class RequestRepository {
    // 테스트용 더미
    val dummy =
        flowOf(
            listOf(
                Request("1", "재무관리 2과 프린트", How.DO, "신세계관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "지지고 참치마요", How.BUY, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "맥북 충전기 C타입", How.LEND, "100주년 기념관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "사물함 대리수령", How.DO, "중앙도서관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "회귀분석 수업시간에 포스트잇", How.BUY, "경영대", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "기숙사 택배 대신 수령", How.DO, "기숙사 A동", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "시험봐야하는데 공학계산기", How.LEND, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "재무관리 2과 프린트", How.DO, "신세계관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "지지고 참치마요", How.BUY, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "맥북 충전기 C타입", How.LEND, "100주년 기념관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "사물함 대리수령", How.DO, "중앙도서관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "회귀분석 수업시간에 포스트잇", How.BUY, "경영대", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "기숙사 택배 대신 수령", How.DO, "기숙사 A동", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, ""),
                Request("1", "시험봐야하는데 공학계산기", How.LEND, "공학관", "dd", LocalDateTime.of(2021, 3, 1, 12, 30), Pay.MONEY, "")
            )
        )

    // 전체

    // 해주세요

    // 사다주세요

    // 빌려주세요

}