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
        println("Creating multiple students")
        val student1 = Student("John", "Doe", "john@luv2code.com")
        val student2 = Student("Mary", "Public", "mary@luv2code.com")
        val student3 = Student("Bonita", "Appelbaum", "bonita@luv2code.com")

        // Start a transaction
        println("Starting a transaction")
        session.beginTransaction()

        // Save the student object
        println("Saving the student objects")
        session.save(student1)
        session.save(student2)
        session.save(student3)

        // Commit transaction
        println("Commit the transaction")
        session.transaction.commit()

        println("Done!")
    }
}
