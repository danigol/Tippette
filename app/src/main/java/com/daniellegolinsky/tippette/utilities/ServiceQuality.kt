package com.daniellegolinsky.tippette.utilities

enum class ServiceQuality(val tipPercentage: Float) {
    WORST(0.1f),
    BAD(0.15f),
    OK(0.18f),
    GOOD(0.20f),
    BEST(0.23f);

    fun value(): Float {
        return this.tipPercentage
    }
}