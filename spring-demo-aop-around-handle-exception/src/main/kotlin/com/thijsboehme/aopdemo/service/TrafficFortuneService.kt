package com.thijsboehme.aopdemo.service

import org.springframework.stereotype.Component

@Component
class TrafficFortuneService {
    fun getFortune(): String {
        // Simulate a delay
        Thread.sleep(5000)

        // Return a fortune
        return "Expect heavy traffic this morning"
    }

    fun getFortune(tripWire: Boolean): String {
        if (tripWire) throw RuntimeException("Major accident! Highway is closed!")

        return getFortune()
    }
}
