package com.kekulta.timetable.ui.extensions

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.annotation.DimenRes
import androidx.annotation.StyleRes
import com.kekulta.timetable.R

val Number.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun TextView.setOrGone(text: String?) {
    if (text.isNullOrBlank()) {
        gone()
    } else {
        this.text = text
        visible()
    }
}

fun TextView.setBubbleStyle(@StyleRes style: Int) {
    val obtainedAttrs = context.run {
        obtainStyledAttributes(style, R.styleable.Bubble)
    }

    val textColor = obtainedAttrs.getColor(R.styleable.Bubble_android_textColor, Color.BLACK)
    val backgroundTint =
        obtainedAttrs.getColor(R.styleable.Bubble_android_backgroundTint, Color.WHITE)

    setTextColor(textColor)
    background?.apply { setTint(backgroundTint) }
}

fun View.getDimen(@DimenRes dimen: Int): Int {
    return resources.getDimension(dimen).toInt()
}