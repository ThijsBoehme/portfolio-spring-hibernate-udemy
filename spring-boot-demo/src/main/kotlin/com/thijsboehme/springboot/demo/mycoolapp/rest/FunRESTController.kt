package com.thijsboehme.springboot.demo.mycoolapp.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class FunRESTController {
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
}
