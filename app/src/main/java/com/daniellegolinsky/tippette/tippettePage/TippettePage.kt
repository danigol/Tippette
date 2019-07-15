package com.daniellegolinsky.tippette.tippettePage

import io.reactivex.Observable

interface TippettePage {
    fun onNextClicked() : Observable<Unit>
}