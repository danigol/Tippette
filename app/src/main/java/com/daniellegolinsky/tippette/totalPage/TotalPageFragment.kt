package com.daniellegolinsky.tippette.totalPage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.daniellegolinsky.tippette.R
import com.daniellegolinsky.tippette.SlideScreenActivity
import com.daniellegolinsky.tippette.TipModel

class TotalPageFragment : Fragment() {

    lateinit var nextButton: Button
    lateinit var totalAmount: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.total_fragment, container, false)

        nextButton = view.findViewById(R.id.next)
        nextButton.setOnClickListener { onNextClicked() }
        totalAmount = view.findViewById(R.id.service_cost_entry)
        totalAmount.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    (activity as SlideScreenActivity).hideSoftKeyboard()
                    onNextClicked()
                    true
                }
                else -> false
            }
        }
        return view
    }

    private fun onNextClicked() {
        if (totalAmount.text != null && totalAmount.text.toString().isNotEmpty()) {
            TipModel.total = totalAmount.text.toString().toDouble()
            if (TipModel.total > 0) {
                TipModel.getNextPage()
                (activity as SlideScreenActivity).onNext()
            } else {
                toastError()
            }
        } else {
            toastError()
        }
    }

    private fun toastError() {
        Toast.makeText(activity, R.string.total_error, Toast.LENGTH_SHORT).show()
    }
}