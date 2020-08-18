package com.thijsboehme.springdemo

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Component
//@Scope("prototype")
class TennisCoach(@Qualifier("randomFortuneService") private var fortuneService: FortuneService): Coach {
//class TennisCoach : Coach {
//    @Autowired
//    @Qualifier("happyFortuneService")
//    private lateinit var fortuneService: FortuneService

    init {
        println(">> TennisCoach: inside the default constructor")
    }

//    @Autowired
//    @Qualifier("happyFortuneService")
//    fun doSomeCrazyStuff(fortuneService: FortuneService) {
//        this.fortuneService = fortuneService
//        println(">> TennisCoach: inside doSomeCrazyStuff() method")
//    }

    @PostConstruct
    private fun doMyStartupStuff() {
        println(">> TennisCoach: inside doMyStartupStuff()")
    }

    @PreDestroy
    private fun doMyCleanupStuff() {
        println(">> TennisCoach: inside doMyCleanupStuff()")
    }

    override fun getDailyWorkout(): String {
        return "Practice your backhand volley"
    }

    override fun getDailyFortune(): String {
        return fortuneService.getFortune()
    }
}
