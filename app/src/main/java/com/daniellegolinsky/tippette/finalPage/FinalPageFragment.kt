package com.daniellegolinsky.tippette.finalPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.daniellegolinsky.tippette.R
import com.daniellegolinsky.tippette.SlideScreenActivity
import com.daniellegolinsky.tippette.TipModel

class FinalPageFragment : androidx.fragment.app.Fragment() {

    lateinit var finalValue: TextView
    lateinit var nextButton: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.pay_up_fragment, container, false)
        finalValue = view.findViewById(R.id.total)
        finalValue.text = tipString()

        nextButton = view.findViewById(R.id.next)
        nextButton.setOnClickListener{ onNextClicked() }

        return view
    }

    fun refresh() {
        finalValue.text = tipString()
    }

    private fun onNextClicked() {
        TipModel.reset()
        TipModel.getNextPage()
        (activity as SlideScreenActivity).onNext()
    }

    private fun tipString(): String {
        return getString(
                R.string.pay_up_amount,
                getString(R.string.currency_symbol),
                TipModel.generateTotal(),
                getString(R.string.currency_symbol),
                TipModel.generateTotalMinusTip(),
                getString(R.string.currency_symbol),
                TipModel.generateTip())
    }
}
