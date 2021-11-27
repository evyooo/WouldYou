package com.yoo.wouldu.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

class KeyBoard {
    fun hideSoftKeyboard(mContext: Context, editText: EditText) {
        if ((mContext as Activity).currentFocus != null && mContext.currentFocus is EditText) {
            val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(editText.windowToken, 0)
        }
    }
}