package com.thijsboehme.hibernate.demo

import com.thijsboehme.hibernate.demo.entity.Course
import com.thijsboehme.hibernate.demo.entity.Instructor
import com.thijsboehme.hibernate.demo.entity.InstructorDetail
import org.hibernate.cfg.Configuration

fun main() {
    // Create session factory
    Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor::class.java)
        .addAnnotatedClass(InstructorDetail::class.java)
        .addAnnotatedClass(Course::class.java)
        .buildSessionFactory()
        .use { factory ->
            // Create session
            factory.currentSession.use { session ->
                // Start a transaction
                session.beginTransaction()

                // Get a course
                val id = 10
                val course: Course? = session.get(Course::class.java, id)

                // Delete the course
                println("Deleting course: $course")
                session.delete(course)

                // Commit transaction
                session.transaction.commit()

                println("Done!")
            }
        }
}
