package com.daniellegolinsky.tippette.servicePage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daniellegolinsky.tippette.R

class ServicePageFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.service_fragment, container, false)
        // TODO Initialization
        return view
    }
}