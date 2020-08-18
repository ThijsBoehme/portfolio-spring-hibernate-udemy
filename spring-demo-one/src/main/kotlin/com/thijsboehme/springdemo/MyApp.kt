package com.thijsboehme.springdemo

class MyApp

fun main(args: Array<String>) {
    // Create the object
    val theCoach: Coach = TrackCoach(HappyFortuneService())

    // Use the object
    println(theCoach.getDailyWorkout())
}
