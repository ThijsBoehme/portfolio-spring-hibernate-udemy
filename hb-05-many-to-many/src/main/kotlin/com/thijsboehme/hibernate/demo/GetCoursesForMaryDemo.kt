package com.thijsboehme.hibernate.demo

import com.thijsboehme.hibernate.demo.entity.*
import org.hibernate.cfg.Configuration

fun main() {
    // Create session factory
    Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor::class.java)
        .addAnnotatedClass(InstructorDetail::class.java)
        .addAnnotatedClass(Course::class.java)
        .addAnnotatedClass(Review::class.java)
        .addAnnotatedClass(Student::class.java)
        .buildSessionFactory()
        .use { factory ->
            // Create session
            factory.currentSession.use { session ->
                // Start a transaction
                session.beginTransaction()

                // Get student Mary
                val id = 2
                val mary: Student? = session.get(Student::class.java, id)

                println("Mary's courses: ${mary?.courses}")

                // Commit transaction
                session.transaction.commit()

                println("Done!")
            }
        }
}
