package com.daniellegolinsky.tippette.totalPage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.daniellegolinsky.tippette.R
import com.daniellegolinsky.tippette.SlideScreenActivity
import com.daniellegolinsky.tippette.TipModel

class TotalPageFragment: Fragment() {

    lateinit var nextButton: Button
    lateinit var totalAmount: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.total_fragment, container, false)

        nextButton = view.findViewById(R.id.next)
        nextButton.setOnClickListener{ onNextClicked() }
        totalAmount = view.findViewById(R.id.service_cost_entry)

        return view
    }

    private fun onNextClicked() {
        TipModel.total = totalAmount.text.toString().toDouble()
        TipModel.getNextPage()
        (activity as SlideScreenActivity).onNext()
    }

}