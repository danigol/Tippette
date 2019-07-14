package com.daniellegolinsky.tippette.utilities

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * A view pager with swiping disabled
 */
class TipViewPager constructor(context: Context, attributeSet: AttributeSet)
    : ViewPager(context, attributeSet) {

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}