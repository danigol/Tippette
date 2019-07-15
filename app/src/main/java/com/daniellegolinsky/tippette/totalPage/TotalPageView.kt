package com.daniellegolinsky.tippette.totalPage

import android.content.Context
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import com.daniellegolinsky.tippette.R
import com.daniellegolinsky.tippette.tippettePage.TippettePage
import io.reactivex.Observable

class TotalPageView private constructor(private val context: Context,
                                        private val view: View) : TippettePage {

    companion object {
        fun create(context: Context, view: View) : TotalPageView {
            return create(context, view)
        }
    }

    var nextButton: Button = view.findViewById(R.id.next)
    var totalAmount: EditText = view.findViewById(R.id.service_cost_entry)
    var hideKeyboard: Boolean = false

    init {
        nextButton.setOnClickListener { onNextClicked() }
        totalAmount.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    onNextClicked()
                    true
                }
                else -> false
            }
        }
        hideKeyboard = totalAmount.requestFocus()
        totalAmount.setOnFocusChangeListener { _, hasFocus ->  hideKeyboard = hasFocus }
    }

    override fun onNextClicked(): Observable<Unit> {
        return Observable.just(Unit)
    }
}