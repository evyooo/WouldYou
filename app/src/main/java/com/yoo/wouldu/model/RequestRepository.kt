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
            Request(
                "1",
                "회계원리 과제 대리 제출",
                How.DO,
                "신세계관",
                "303호",
                LocalDateTime.of(2021, 11, 27, 12, 30),
                Pay.TRANSFER,
                "3500",
                "제가 스캔본보내드리면 프린트해서 제출해주시면 됩니다. 사례는 프린트값(2장) 포함입니다. ",
                "이니마니모",
                "17학번",
                "여자",
                LocalDateTime.of(2021, 11, 25, 1, 5),
                Status.ACTIVE
            ),
            Request(
                "1",
                "공차 초코 밀크티",
                How.BUY,
                "신공학관",
                "501호",
                LocalDateTime.of(2021, 11, 26, 9, 30),
                Pay.TRANSFER,
                "7000",
                "펄 빼주고 당도 50%로 해주세요. 초코 밀크티 값 포함 사례입니다.",
                "냥냥펀치",
                "18학번",
                "남자",
                LocalDateTime.of(2021, 11, 25, 1, 5),
                Status.MATCHED
            ),
            Request(
                "1",
                "기초확률론 교재",
                How.BUY,
                "이화캠퍼스복합단지",
                "YBM열람실 앞 사물함",
                LocalDateTime.of(2021, 11, 30, 12, 10),
                Pay.GIFTICON,
                "4500",
                "신공학관 지하1층 과사무실에 파는 기초확률론 교재 사서 이씨씨 사물함에 넣어주세요. 2학년 과목입니다.",
                "뽀삐뽀삐",
                "19학번",
                "여자",
                LocalDateTime.of(2021, 11, 29, 11, 50),
                Status.ACTIVE
            ),
            Request(
                "1",
                "기숙사에 온 택배 찾아주기",
                How.DO,
                "한우리집",
                "1층 무인택배함",
                LocalDateTime.of(2021, 11, 30, 11, 0),
                Pay.TRANSFER,
                "3000",
                "기숙사에 온 제 택배 찾아서 ECC 사물함에 넣어주실분 구합니다ㅜㅜ 책 한권이라 무겁지 않아요! ",
                "지니요정",
                "20학번",
                "여자",
                LocalDateTime.of(2021, 12,3, 10, 30),
                Status.DONE
            ),
            Request(
                "1",
                "공학용 계산기",
                How.LEND,
                "포스코관",
                "103호",
                LocalDateTime.of(2021, 11, 23, 5, 0),
                Pay.NONE,
                "0",
                "시험때문에 급하게 빌립니다. 5시까지 빌려주실분 구합니다!! 시험끝나면 있는 곳까지 가서 돌려드릴게요..",
                "김치전먹자",
                "19학번",
                "남자",
                LocalDateTime.of(2021, 11, 23, 3, 15),
                Status.ACTIVE
            ),
            Request(
                "1",
                "영어인증서 대신 제출",
                How.DO,
                "SK텔레콤관",
                "지하1층 과사무실",
                LocalDateTime.of(2021, 11, 25, 5, 0),
                Pay.MONEY,
                "2000",
                "정문에서 파일 드릴테니까 과사무실에 제출해주시면 감사하겠습니다. 꼭 5시까지 제출해주실분 구합니다.",
                "피글렛왕",
                "16학번",
                "남자",
                LocalDateTime.of(2021, 11,24, 11, 30),
                Status.MATCHED
            ),
            Request(
                "1",
                "노트북 충전기",
                How.LEND,
                "국제교육관",
                "1층 라운지",
                LocalDateTime.of(2021, 11, 25, 3, 30),
                Pay.ELSE,
                "2000",
                "맥북 2018년형 충전기 빌립니다. 30분만 사용하고 바로 돌려드리겠습니다.2천원어치 귤 드릴게요ㅜㅜㅜ 돈이없어서 이걸로 대체합니다",
                "겨울이었다",
                "16학번",
                "여자",
                LocalDateTime.of(2021, 11, 25, 2, 35),
                Status.MATCHED
            ),
            Request(
                "1",
                "타이포그래피 과제2 프린트",
                How.DO,
                "조형예술관A동",
                "과사무실",
                LocalDateTime.of(2021, 11, 28, 12, 30),
                Pay.TRANSFER,
                "3500",
                "파일 이메일로 보내드리면 프린트해주실분 구합니다. 인쇄소에 미대 과제용으로 프린트한다하면 사양 맞춰주실겁니다! 채팅으로 자세히 알려드릴게요. ",
                "뿌셔버려",
                "19학번",
                "여자",
                LocalDateTime.of(2021, 11, 28, 9, 45),
                Status.EXPIRED
            ),
            Request(
                "1",
                "학교 공식 파우치",
                How.BUY,
                "학문관",
                "321호",
                LocalDateTime.of(2021, 11, 24, 7, 10),
                Pay.ELSE,
                "9000",
                "생협이나 기념품샵에 파우치사주시면 됩니다. 어떤 종류가 있는지 몰라서 결정되면 가격이나 사례지급방식이 달라질 것 같아요! ",
                "꿍사랑단",
                "17학번",
                "남자",
                LocalDateTime.of(2021, 11, 20, 11, 50),
                Status.EXPIRED
            ),
            Request(
                "1",
                "사회복지개론 책",
                How.LEND,
                "포스코관",
                "303호",
                LocalDateTime.of(2021, 11, 25, 3, 30),
                Pay.GIFTICON,
                "3500",
                "오픈북 시험용으로 1시간 30분만 사용하고 5시에 바로 돌려드릴게요. 2021년 개정판으로 부탁드립니다",
                "노리밋뽀이",
                "15학번",
                "남자",
                LocalDateTime.of(2021, 11, 25, 1, 0),
                Status.ACTIVE
            )
        )

    // 전체

}