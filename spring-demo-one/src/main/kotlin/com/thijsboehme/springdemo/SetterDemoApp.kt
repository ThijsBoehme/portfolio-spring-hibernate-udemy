package com.thijsboehme.springdemo

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main() {
    // Load the Spring configuration file
    val context = ClassPathXmlApplicationContext("applicationContext.xml")

    // Retrieve bean from Spring container
    val theCoach = context.getBean("myCricketCoach", CricketCoach::class.java)

    // Call methods on the bean
    println(theCoach.getDailyWorkout())
    println(theCoach.getDailyFortune())
    println(theCoach.emailAddress)
    println(theCoach.team)

    // Close the context
    context.close()
}
