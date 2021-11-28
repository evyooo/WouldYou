package com.yoo.wouldu.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.yoo.wouldu.R
import com.yoo.wouldu.model.data.request.How
import com.yoo.wouldu.model.data.request.Pay
import com.yoo.wouldu.model.data.request.Status
import java.time.Duration
import java.time.LocalDateTime


@BindingAdapter("count_30")
fun setCoun30(view: TextView, curLength: Int?) {
    if (curLength != null) {
        val stepString = "$curLength/30"
        view.text = stepString
    }
}

@BindingAdapter("count_100")
fun setCount100(view: TextView, curLength: Int?) {
    if (curLength != null) {
        val stepString = "$curLength/100"
        view.text = stepString
    }
}

@BindingAdapter("how")
fun setHow(view: TextView, how: How) {
    val str = when (how) {
        How.DO -> "해주세요"
        How.BUY -> "사다주세요"
        How.LEND -> "빌려주세요"
    }
    view.text = str
}

@BindingAdapter("how_color")
fun setHowColor(view: TextView, how: How) {
    setHow(view, how)
    val color = when (how) {
        How.DO -> R.color.sub01
        How.LEND -> R.color.sub02
        How.BUY -> R.color.sub03
    }
    view.setTextColor(view.context.getColor(color))
}

@BindingAdapter("how_img")
fun setHowImage(view: ImageView, how: How) {
    val img = when (how) {
        How.DO -> R.drawable.ic_main_do
        How.LEND -> R.drawable.ic_main_lend
        How.BUY -> R.drawable.ic_main_buy
    }
    view.setImageResource(img)
}

@BindingAdapter("status", "how")
fun setStatus(view: TextView, status: Status, how: How) {
    when (status) {
        Status.MATCHED -> {
            view.text = "약속 중"
            view.setTextColor(view.context.getColor(R.color.caption02))
        }
        Status.DONE -> {
            view.text = "해결 완료"
            view.setTextColor(view.context.getColor(R.color.caption02))
        }
        Status.EXPIRED -> {
            view.text = "만료됨"
            view.setTextColor(view.context.getColor(R.color.caption02))
        }
        Status.ACTIVE -> {
            setHow(view, how)
            val color = when (how) {
                How.DO -> R.color.sub01
                How.LEND -> R.color.sub02
                How.BUY -> R.color.sub03
            }
            view.setTextColor(view.context.getColor(color))
        }
    }
}

@BindingAdapter("status", "how")
fun setStatusIcon(view: ImageView, status: Status, how: How) {
    when (status) {
        Status.MATCHED -> {
            view.setImageResource(R.drawable.ic_done)
        }
        Status.DONE -> {
            view.visibility = View.GONE
        }
        Status.EXPIRED -> {
            view.visibility = View.GONE
        }
        Status.ACTIVE -> {
            val img = when (how) {
                How.DO -> R.drawable.ic_main_do
                How.LEND -> R.drawable.ic_main_lend
                How.BUY -> R.drawable.ic_main_buy
            }
            view.setImageResource(img)
        }
    }
}


@BindingAdapter("due")
fun setDatetime(view: TextView, dateTime: LocalDateTime) {
    val date = "${dateTime.year}.${dateTime.monthValue}.${dateTime.dayOfMonth}"
    val time = if (dateTime.hour > 12) {
        "PM ${dateTime.hour - 12}:${dateTime.minute}"
    } else {
        "AM ${dateTime.hour}:${dateTime.minute}"
    }
    view.text = "$date $time"
}

@BindingAdapter("duedate")
fun setDate(view: TextView, dateTime: LocalDateTime) {
    view.text = "${dateTime.year}년 ${dateTime.monthValue}월 ${dateTime.dayOfMonth}일"
}

@BindingAdapter("duetime")
fun setTime(view: TextView, dateTime: LocalDateTime) {
    val time = if (dateTime.hour > 12) {
        "오후 ${dateTime.hour - 12}시 ${dateTime.minute}분"
    } else {
        "오전 ${dateTime.hour}시 ${dateTime.minute}분"
    }
    view.text = time
}

@BindingAdapter("payType")
fun setPay(view: TextView, payType: Pay) {
    val str = when (payType) {
        Pay.MONEY -> "만나서 현금"
        Pay.ELSE -> "기타 사례"
        Pay.GIFTICON -> "기프티콘"
        Pay.NONE -> "사례 없음"
        Pay.TRANSFER -> "계좌이체"
    }
    view.text = str
}

@BindingAdapter("payAmount")
fun setAmount(view: TextView, amount: String) {
    view.text = "${amount}원"
}

@BindingAdapter("writer_sex", "writer_grade")
fun setWriterDetail(view: TextView, writer_sex: String, writer_grade: String) {
    view.text = "$writer_grade | $writer_sex"
}

/**
 * 1시간 내 > 'n분 전'으로 표시
 * 당일 내 > 24시 기준 수치로 표시 (ex. 06:10)
 */
@BindingAdapter("writtenTime")
fun setWrittenTime(view: TextView, writtenTime: LocalDateTime) {
    if (writtenTime.isAfter(LocalDateTime.now().minusHours(1))) {
        val duration = Duration.between(writtenTime, LocalDateTime.now())
        view.text = "${duration.toMinutes()}분 전"
    } else if (writtenTime.isAfter(LocalDateTime.now().minusHours(24))) {
        view.text = "${writtenTime.hour}:${writtenTime.minute}"
    } else {
        view.text = "${writtenTime.year}-${writtenTime.monthValue}-${writtenTime.dayOfMonth}"
    }
}

@BindingAdapter("spinner_year", "spinner_month", "spinner_day")
fun setSpinnerDate(view: TextView, spinner_year: String, spinner_month: String, spinner_day: String) {
    view.text = "${spinner_year}년 ${spinner_month}월 ${spinner_day}일"
}




