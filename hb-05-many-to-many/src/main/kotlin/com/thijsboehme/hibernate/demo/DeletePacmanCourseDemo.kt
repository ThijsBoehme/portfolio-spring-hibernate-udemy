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

                // Get Pacman course
                val id = 10
                val pacmanCourse: Course? = session.get(Course::class.java, id)

                // Delete the course
                // This does not delete the enrolled students, but does remove the correct entries in the jointable
                session.delete(pacmanCourse)

                // Commit transaction
                session.transaction.commit()

                println("Done!")
            }
        }
}
