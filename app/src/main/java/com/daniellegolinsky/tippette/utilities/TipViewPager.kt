package com.daniellegolinsky.tippette.utilities

import android.content.Context
import androidx.viewpager.widget.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * A view pager with swiping disabled
 */
class TipViewPager constructor(context: Context, attributeSet: AttributeSet)
    : androidx.viewpager.widget.ViewPager(context, attributeSet) {

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

}