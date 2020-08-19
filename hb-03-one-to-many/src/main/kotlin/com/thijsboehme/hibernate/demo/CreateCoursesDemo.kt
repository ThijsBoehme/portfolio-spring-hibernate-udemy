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

                // Get the instructor from the database
                val id = 1
                val instructor: Instructor? = session.get(Instructor::class.java, id)

                // Create some courses
                val course1 = Course("Air Guitar - The Ultimate Guide")
                val course2 = Course("The Pinball Masterclass")

                // Add courses to instructor
                instructor?.add(course1)
                instructor?.add(course2)

                // Save the courses
                session.save(course1)
                session.save(course2)

                // Commit transaction
                session.transaction.commit()

                println("Done!")
            }
        }
}
