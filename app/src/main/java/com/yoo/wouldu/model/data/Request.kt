package com.yoo.wouldu.model.data

import java.time.LocalDateTime

/**
 * params
 *     id: 고유 아이디
 *     what: 무엇을
 *     how: (enum) 해주세요 / 사다주세요 / 빌려주세요
 *     where: 어디서
 *     whereDetail: 장소 상세 (nullable)
 *     due: 언제까지
 *     pay: (enum) 계좌이체 / 만나서 현금 / 기프티콘 / 기타 사례 / 사례 없음
 *     payAmount: (nullable) 사례 금액
 *     message: (nullable) 할말
 *     writer: 작성자
 *     postDate: 작성일자
 *     status: (enum) 구하는중 / 매칭됨 / 완료 / 만료
 */
data class Request(
    val id: String,
    var what: String,
    var how: How,
    var where: String,
    var whereDetail: String?,
    var due: LocalDateTime,
    var pay: Pay,
    var payAmount: String?,
    var message: String?,
    var writer: String,
    var postDate: LocalDateTime,
    var status: Status
)
