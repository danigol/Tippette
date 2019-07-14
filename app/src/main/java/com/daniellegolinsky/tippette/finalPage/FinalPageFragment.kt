package com.daniellegolinsky.tippette.finalPage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.daniellegolinsky.tippette.R
import com.daniellegolinsky.tippette.SlideScreenActivity
import com.daniellegolinsky.tippette.TipModel

class FinalPageFragment : Fragment() {

    lateinit var finalValue: TextView
    lateinit var nextButton: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.pay_up_fragment, container, false)
        finalValue = view.findViewById(R.id.total)
        finalValue.text = getString(
                            R.string.pay_up_amount,
                            getString(R.string.currency_symbol),
                            TipModel.generateTotal())

        nextButton = view.findViewById(R.id.next)
        nextButton.setOnClickListener{ onNextClicked() }
        return view
    }

    private fun onNextClicked() {
        TipModel.reset()
        TipModel.getNextPage()
        (activity as SlideScreenActivity).onNext()
    }
}
