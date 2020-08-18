package com.thijsboehme.springdemo

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main() {
    // Read Spring configuration file
    val context = ClassPathXmlApplicationContext("applicationContext.xml")

    // Get bean from Spring container
    val theCoach = context.getBean("tennisCoach", Coach::class.java)

    // Call methods on bean
    println(theCoach.getDailyWorkout())
    println(theCoach.getDailyFortune())

    // Close container
    context.close()
}
