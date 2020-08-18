package com.thijsboehme.springdemo

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main() {
    // Load Spring configuration file
    val context = ClassPathXmlApplicationContext("applicationContext.xml")

    // Retrieve bean from Spring container
    val theCoach = context.getBean("myCoach", Coach::class.java)

    // Call methods on the bean
    println(theCoach.getDailyWorkout())

    // Let's call our new method for fortunes
    println(theCoach.getDailyFortune())

    // Close the context
    context.close()
}
