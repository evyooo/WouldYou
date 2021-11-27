package com.yoo.wouldu.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

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