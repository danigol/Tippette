package com.daniellegolinsky.tippette.peoplePage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.daniellegolinsky.tippette.R
import com.daniellegolinsky.tippette.SlideScreenActivity
import com.daniellegolinsky.tippette.TipModel

class PeoplePageFragment : Fragment() {

    lateinit var nextButton: Button
    lateinit var peopleSlider: SeekBar
    lateinit var peopleValue: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.people_fragment, container, false)

        nextButton = view.findViewById(R.id.next)
        nextButton.setOnClickListener{ onNextClicked() }

        peopleValue = view.findViewById(R.id.people_slider_value)

        peopleSlider = view.findViewById(R.id.people_slider)
        peopleSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Enforce min on older devices
                var p = progress
                if (p < 1) {
                    p = 1
                    seekBar.progress = 1
                }
                peopleValue.text = p.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })

        return view
    }

    private fun getPeopleSliderProgress(): Int {
        if (peopleSlider != null && peopleSlider.progress < 1) {
            return 1
        }
        return peopleSlider.progress
    }

    private fun onNextClicked() {
        TipModel.peoplePaying = getPeopleSliderProgress()
        TipModel.getNextPage()
        (activity as SlideScreenActivity).onNext()
    }
}