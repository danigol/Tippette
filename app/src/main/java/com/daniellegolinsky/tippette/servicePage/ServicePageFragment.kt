package com.daniellegolinsky.tippette.servicePage

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
import com.daniellegolinsky.tippette.utilities.ServiceQuality

class ServicePageFragment : Fragment() {

    lateinit var serviceSlider: SeekBar
    lateinit var serviceText: TextView
    lateinit var nextButton: Button

    var serviceQuality: ServiceQuality = ServiceQuality.OK

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.service_fragment, container, false)
        serviceText = view.findViewById(R.id.service_value)
        serviceSlider = view.findViewById(R.id.service_slider)
        serviceSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                var quality: ServiceQuality = ServiceQuality.getService(progress)
                serviceText.setText(ServiceQuality.getServiceStringResource(quality))
                serviceQuality = quality
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        })
        nextButton = view.findViewById(R.id.next)
        nextButton.setOnClickListener { onNextClicked() }

        return view
    }

    private fun onNextClicked() {
        TipModel.service = serviceQuality
        TipModel.getNextPage()
        (activity as SlideScreenActivity).updateFinalPage()
        (activity as SlideScreenActivity).onNext()
    }
}