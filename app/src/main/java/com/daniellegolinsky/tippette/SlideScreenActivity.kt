package com.daniellegolinsky.tippette

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.daniellegolinsky.tippette.finalPage.FinalPageFragment
import com.daniellegolinsky.tippette.peoplePage.PeoplePageFragment
import com.daniellegolinsky.tippette.servicePage.ServicePageFragment
import com.daniellegolinsky.tippette.totalPage.TotalPageFragment
import com.daniellegolinsky.tippette.utilities.TipViewPager
import com.daniellegolinsky.tippette.utilities.ZoomOutPageTransformer

private const val NUM_PAGES = 4

class SlideScreenActivity : androidx.fragment.app.FragmentActivity() {

    private lateinit var pager: TipViewPager

    private lateinit var finalPageFragment: FinalPageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pay_up)
        pager = findViewById(R.id.pager)
        val pagerAdapter = SlideScreenPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
        pager.setPageTransformer(true, ZoomOutPageTransformer())
        finalPageFragment = FinalPageFragment()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }

    override fun onBackPressed() {
        if (pager.currentItem == 0) {
            super.onBackPressed()
        }
        else {
            pager.currentItem = pager.currentItem - 1
        }
    }

    fun onNext() {
        if (pager.currentItem < 3) {
            pager.currentItem++
        }
        else {
            pager.currentItem = 0
        }
    }

    fun updateFinalPage() {
        finalPageFragment.refresh()
    }

    fun hideSoftKeyboard() {
        var inputMethodManager: InputMethodManager = (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        inputMethodManager.hideSoftInputFromWindow(
                currentFocus?.windowToken, 0)
    }

    // Pager adapter for the slide screen pager view
    private inner class SlideScreenPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUM_PAGES
        override fun getItem(position: Int): androidx.fragment.app.Fragment {
            return when(position) {
                0 -> TotalPageFragment()
                1 -> PeoplePageFragment()
                2 -> ServicePageFragment()
                3 -> finalPageFragment
                else -> TotalPageFragment()
            }
        }
    }
}