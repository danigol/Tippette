package com.daniellegolinsky.tippette

import com.daniellegolinsky.tippette.utilities.ServiceQuality

object TipModel {

    var currentPage: Int = 0
    var total: Double = 0.0
    var peoplePaying: Int = 1
    var service: ServiceQuality = ServiceQuality.OK

    fun getNextPage(): Int {
        if (currentPage > 2) {
            currentPage = 0
        }
        return currentPage++
    }

    fun generateTotal() : Double {
        return ((total * service.value()) + total) / peoplePaying
    }

    fun reset() {
        currentPage = 0
        total = 0.0
        peoplePaying = 1
        service = ServiceQuality.OK
    }
}