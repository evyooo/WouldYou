package com.yoo.wouldu.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.yoo.wouldu.R
import com.yoo.wouldu.model.data.request.How
import com.yoo.wouldu.model.data.request.Pay
import java.time.LocalDateTime

@BindingAdapter("count_30")
fun setCoun30(view: TextView, curLength: Int?) {
    if(curLength != null) {
        val stepString = "$curLength/30"
        view.text = stepString
    }
}

@BindingAdapter("count_100")
fun setCount100(view: TextView, curLength: Int?) {
    if(curLength != null) {
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