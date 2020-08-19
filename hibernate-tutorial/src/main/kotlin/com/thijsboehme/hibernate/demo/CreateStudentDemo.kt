package com.thijsboehme.hibernate.demo

import com.thijsboehme.hibernate.demo.entity.Student
import org.hibernate.cfg.Configuration

fun main() {
    // Create session factory
    val factory = Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student::class.java)
        .buildSessionFactory()

    factory.use {
        // Create session
        val session = it.currentSession

        // Create a student object
        println("Creating a student object")
        val student = Student("Paul", "Wall", "paul@luv2code.com")

        // Start a transaction
        println("Starting a transaction")
        session.beginTransaction()

        // Save the student object
        println("Saving the student object")
        session.save(student)

        // Commit transaction
        println("Commit the transaction")
        session.transaction.commit()

        println("Done!")
    }
}
