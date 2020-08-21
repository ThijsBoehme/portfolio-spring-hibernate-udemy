package com.thijsboehme.aopdemo

import com.thijsboehme.aopdemo.service.TrafficFortuneService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    // Read Spring config java class
    AnnotationConfigApplicationContext(DemoConfig::class.java).use { context ->
        // Get beans from Spring container
        val fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService::class.java)

        println()
        println("Main Program: AroundDemoApp")
        println("Calling getFortune")

        val tripWire = true
        val fortune = fortuneService.getFortune(tripWire)

        println()
        println("My fortune is: $fortune")
        println("Finished")

        // Close the context
    }
}
