package com.daniellegolinsky.tippette

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager

private const val PAGES = 5

class SlideScreenActivity : FragmentActivity() {

    private lateinit var pager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_pay_up)

    }
}