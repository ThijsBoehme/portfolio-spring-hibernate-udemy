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
        val studentId = 1

        // Create session
        var session = it.currentSession

        // Start a transaction
        println("Starting a transaction")
        session.beginTransaction()

        // Retrieve student based on the id
        println("Getting student with id: $studentId")
        val student = session.get(Student::class.java, studentId)

        println("Updating student...")
        student.firstName = "Scooby"

        // Commit transaction
        println("Commit the transaction")
        session.transaction.commit()

        // New code
        session = it.currentSession
        session.beginTransaction()

        // Update email for all students
        println("Updating email for all students")
        session.createQuery("update Student set email='foo@gmail.com'")
            .executeUpdate()

        session.transaction.commit()

        println("Done!")
    }
}
