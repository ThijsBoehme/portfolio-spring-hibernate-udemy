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

                // Create a course
                val course = Course("Pacman - How To Score One Million Points")

                // Save the course ... and leverage the cascade all (to save the reviews)
                session.save(course)

                // Create the students
                val student1 = Student("John", "Doe", "john@luv2code.com")
                val student2 = Student("Mary", "Public", "mary@luv2code.com")

                // Add the students to the course
                course.add(student1)
                course.add(student2)

                // Save the students
                session.save(student1)
                session.save(student2)

                // Commit transaction
                session.transaction.commit()

                println("Done!")
            }
        }
}
