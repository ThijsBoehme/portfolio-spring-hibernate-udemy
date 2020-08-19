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
                println("Instructor: $instructor")

                // Get courses of the instructor
                println("Courses: ${instructor?.courses}")

                // Commit transaction
                session.transaction.commit()

                // Possibly breaking the code because the courses are loaded lazily
                session.close()
                println("Courses: ${instructor?.courses}")

                println("Done!")
            }
        }
}
