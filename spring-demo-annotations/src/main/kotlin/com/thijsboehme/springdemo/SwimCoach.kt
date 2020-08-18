package com.thijsboehme.springdemo

import org.springframework.beans.factory.annotation.Value

class SwimCoach(private var fortuneService: FortuneService): Coach {
    @Value("\${foo.email}")
    lateinit var email: String
        private set

    @Value("\${foo.team}")
    lateinit var team: String
        private set

    override fun getDailyWorkout(): String {
        return "Swim 1000 meters as a warm up."
    }

    override fun getDailyFortune(): String {
        return fortuneService.getFortune()
    }
}
