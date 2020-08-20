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

                // Create more courses
                val course1 = Course("Rubik's Cube - How to Speed Cube")
                val course2 = Course("Atari 2600 - Game Development")

                // Add Mary to the courses
                if (mary != null) {
                    course1.add(mary)
                    course2.add(mary)
                }

                // Save the courses
                session.save(course1)
                session.save(course2)

                // Commit transaction
                session.transaction.commit()

                println("Done!")
            }
        }
}
