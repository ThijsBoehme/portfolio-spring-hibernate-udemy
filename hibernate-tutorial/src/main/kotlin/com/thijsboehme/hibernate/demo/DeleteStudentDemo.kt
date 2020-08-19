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
        val session = it.currentSession

        // Start a transaction
        println("Starting a transaction")
        session.beginTransaction()

        // Retrieve student based on the id
        println("Getting student with id: $studentId")
        val student = session.get(Student::class.java, studentId)

        // Delete the student
        if (student != null) {
            println("Deleting student: $student")
            session.delete(student)
        }

        // Delete student id=2
        println("Deleting student with id=2")
        session.createQuery("delete from Student where id=2").executeUpdate()

        // Commit transaction
        println("Commit the transaction")
        session.transaction.commit()

        println("Done!")
    }
}
