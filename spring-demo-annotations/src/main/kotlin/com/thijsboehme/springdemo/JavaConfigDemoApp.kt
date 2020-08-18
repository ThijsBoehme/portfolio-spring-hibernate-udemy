package com.thijsboehme.springdemo

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    // Read Spring configuration file
    val context = AnnotationConfigApplicationContext(SportConfig::class.java)

    // Get bean from Spring container
    val theCoach = context.getBean("tennisCoach", Coach::class.java)

    // Call methods on bean
    println(theCoach.getDailyWorkout())
    println(theCoach.getDailyFortune())

    // Close container
    context.close()
}
