package com.daniellegolinsky.tippette

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager

private const val NUM_PAGES = 5

class SlideScreenActivity : FragmentActivity() {

    private lateinit var pager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_pay_up)

        pager = findViewById(R.id.pager)
        val pagerAdapter = SlideScreenPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
        pager.setPageTransformer(true, ZoomOutPageTransformer())
    }

    override fun onBackPressed() {
        if (pager.currentItem == 0) {
            super.onBackPressed()
        }
        else {
            pager.currentItem = pager.currentItem - 1
        }
    }


    // Pager adapter for the slide screen pager view
    private inner class SlideScreenPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUM_PAGES
        override fun getItem(position: Int): Fragment = TipPageFragment()
    }
}