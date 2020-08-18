package com.thijsboehme.springdemo

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main() {
    // Read Spring configuration file
    val context = ClassPathXmlApplicationContext("applicationContext.xml")

    // Get bean from Spring container
    val theCoach = context.getBean("tennisCoach", Coach::class.java)
    val alphaCoach = context.getBean("tennisCoach", Coach::class.java)

    // Call methods on bean
    val identical = theCoach === alphaCoach
    println("Pointing to the same object: $identical")
    println("Memory location for theCoach: $theCoach")
    println("Memory location for alphaCoach: $alphaCoach")

    // Close container
    context.close()
}
