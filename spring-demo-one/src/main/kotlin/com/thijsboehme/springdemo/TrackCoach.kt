package com.thijsboehme.springdemo

class TrackCoach(private val fortuneService: FortuneService) : Coach {
    override fun getDailyWorkout(): String {
        return "Run a hard 5k"
    }

    override fun getDailyFortune(): String {
        return "Just Do It: " + fortuneService.getFortune()
    }

    fun doMyStartupStuff() {
        println("TrackCoach: inside method doMyStartupStuff")
    }

    fun doMyCleanupStuff() {
        println("TrackCoach: inside method doMyCleanupStuff")
    }
}
