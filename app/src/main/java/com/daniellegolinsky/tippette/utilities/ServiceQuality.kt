package com.daniellegolinsky.tippette.utilities

import com.daniellegolinsky.tippette.R

enum class ServiceQuality(private var tipPercentage: Float) {
    WORST(0.1f),
    BAD(0.15f),
    OK(0.18f),
    GOOD(0.20f),
    BEST(0.23f);

    companion object {
        fun getService(sliderValue: Int): ServiceQuality {
            return when (sliderValue) {
                0 -> WORST
                1 -> BAD
                2 -> OK
                3 -> GOOD
                else -> BEST
            }
        }

        fun getServiceStringResource(quality: ServiceQuality): Int {
            return when (quality) {
                WORST -> R.string.service_quality_label_1
                BAD -> R.string.service_quality_label_2
                OK -> R.string.service_quality_label_3
                GOOD -> R.string.service_quality_label_4
                else -> R.string.service_quality_label_5
            }
        }
    }

    fun value(): Float {
        return this.tipPercentage
    }
}