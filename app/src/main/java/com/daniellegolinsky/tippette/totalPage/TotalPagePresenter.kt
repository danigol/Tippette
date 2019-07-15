package com.daniellegolinsky.tippette.totalPage

import io.reactivex.disposables.CompositeDisposable

class TotalPagePresenter private constructor(view: TotalPageView) {

    companion object {
        fun create(view: TotalPageView) : TotalPagePresenter {
            return TotalPagePresenter(view)
        }
    }

    var compositDisposable: CompositeDisposable = CompositeDisposable()

    init {
        compositDisposable.add(view.onNextClicked().subscribe { next() })
    }

    fun next() {
        
    }

    fun unbindView() {
    }
}