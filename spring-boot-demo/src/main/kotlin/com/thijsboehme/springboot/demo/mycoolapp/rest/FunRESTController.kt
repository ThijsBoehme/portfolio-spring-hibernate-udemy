package com.thijsboehme.springboot.demo.mycoolapp.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class FunRESTController(
    // Inject properties for coach.name and team.name
    @Value("\${coach.name}")
    private val coachName: String,

    @Value("\${team.name}")
    private val teamName: String
) {
    @GetMapping("/")
    fun sayHello(): String {
        return "Hello World! Time on the server is ${LocalDateTime.now()}"
    }

    @GetMapping("/workout")
    fun getDailyWorkout(): String {
        return "Run a hard 5k!"
    }

    @GetMapping("/fortune")
    fun getFortune(): String {
        return "Today is your lucky day!"
    }

    @GetMapping("/teaminfo")
    fun getTeamInfo(): String {
        return "Coach: $coachName, Team: $teamName"
    }
}
