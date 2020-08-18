package com.thijsboehme.springdemo

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main() {
    // Load the spring configuration file
    val context = ClassPathXmlApplicationContext("beanScope-applicationContext.xml")

    // Retrieve beans from Spring container
    val theCoach = context.getBean("myCoach", Coach::class.java)
    val alphaCoach = context.getBean("myCoach", Coach::class.java)

    // Check if they are the same
    val identical = theCoach === alphaCoach

    // Print out the results
    println("Pointing to the same object? $identical")
    println("Memory location for theCoach: $theCoach")
    println("Memory location for alphaCoach: $alphaCoach")

    // Close context
    context.close()
}
