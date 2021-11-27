package com.yoo.wouldu.view

import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yoo.wouldu.R

class SelectDialog() : BottomSheetDialogFragment() {

    override fun getTheme(): Int {
        return R.style.NoBackgroundDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = View.inflate(context, R.layout.dialog_selectrequest, null)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMargin(view)
    }

    private fun addMargin(view: View) {
        val layoutParams: ConstraintLayout.LayoutParams =
            view.layoutParams as ConstraintLayout.LayoutParams
        val margin_16dp = 16.toPx().toInt()
        layoutParams.setMargins(margin_16dp, margin_16dp, margin_16dp, margin_16dp)

        view.layoutParams = layoutParams
    }


    fun Number.toPx() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )
}