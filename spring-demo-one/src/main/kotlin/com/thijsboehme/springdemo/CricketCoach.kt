package com.thijsboehme.springdemo

class CricketCoach : Coach {
    lateinit var fortuneService: FortuneService
    lateinit var emailAddress: String
    lateinit var team: String

    init {
        println("CricketCoach: inside no-arg constructor")
    }

    override fun getDailyWorkout(): String {
        return "Practice fast bowling for 15 minutes"
    }

    override fun getDailyFortune(): String {
        return fortuneService.getFortune()
    }
}
