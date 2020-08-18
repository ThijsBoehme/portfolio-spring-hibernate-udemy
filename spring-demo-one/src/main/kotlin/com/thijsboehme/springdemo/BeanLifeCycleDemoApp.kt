package com.thijsboehme.springdemo

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main() {
    // Load the spring configuration file
    val context = ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml")

    // Retrieve beans from Spring container
    val theCoach = context.getBean("myCoach", Coach::class.java)

    println(theCoach.getDailyWorkout())

    // Close context
    context.close()
}
