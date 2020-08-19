package com.thijsboehme.hibernate.demo

import com.thijsboehme.hibernate.demo.entity.Course
import com.thijsboehme.hibernate.demo.entity.Instructor
import com.thijsboehme.hibernate.demo.entity.InstructorDetail
import com.thijsboehme.hibernate.demo.entity.Review
import org.hibernate.cfg.Configuration

fun main() {
    // Create session factory
    Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor::class.java)
        .addAnnotatedClass(InstructorDetail::class.java)
        .addAnnotatedClass(Course::class.java)
        .addAnnotatedClass(Review::class.java)
        .buildSessionFactory()
        .use { factory ->
            // Create session
            factory.currentSession.use { session ->
                // Start a transaction
                session.beginTransaction()

                // Create a course
                val course = Course("Pacman - How To Score One Million Points")

                // Add some reviews
                course.add(Review("Great course ... loved it!"))
                course.add(Review("Cool course, job well done"))
                course.add(Review("What a dumb course, you are an idiot"))

                // Save the course ... and leverage the cascade all (to save the reviews)
                session.save(course)

                // Commit transaction
                session.transaction.commit()

                println("Done!")
            }
        }
}
