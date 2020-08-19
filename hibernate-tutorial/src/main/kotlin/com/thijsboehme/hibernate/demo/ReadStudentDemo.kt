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
        var session = it.currentSession

        // Create a student object
        println("Creating a student object")
        val student = Student("Daffy", "Duck", "daffy@luv2code.com")

        // Start a transaction
        println("Starting a transaction")
        session.beginTransaction()

        // Save the student object
        println("Saving the student object")
        session.save(student)

        // Commit transaction
        println("Commit the transaction")
        session.transaction.commit()

        // New code
        // Find out the student's id: primary key
        println("Saved student. Generated id: ${student.id}")

        // Get a new session and start transaction
        session = it.currentSession
        session.beginTransaction()

        // Retrieve student based on the id: primary key
        println("Getting student with id: ${student.id}")
        val retrievedStudent = session.get(Student::class.java, student.id)
        println("Get complete: $retrievedStudent")

        // Commit the transaction
        session.transaction.commit()

        println("Done!")
    }
}
