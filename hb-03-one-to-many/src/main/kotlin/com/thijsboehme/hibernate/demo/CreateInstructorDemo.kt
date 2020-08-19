package com.thijsboehme.hibernate.demo

import com.thijsboehme.hibernate.demo.entity.Course
import com.thijsboehme.hibernate.demo.entity.Instructor
import com.thijsboehme.hibernate.demo.entity.InstructorDetail
import org.hibernate.cfg.Configuration

fun main() {
    // Create session factory
    val factory = Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor::class.java)
        .addAnnotatedClass(InstructorDetail::class.java)
        .addAnnotatedClass(Course::class.java)
        .buildSessionFactory()

    factory.use {
        // Create session
        it.currentSession.use { session ->
            val instructor = Instructor("Susan", "Public", "susan.public@luv2code.com")
            val instructorDetail = InstructorDetail("http://www.youtube.com", "Video Games")

            // Associate the objects together
            instructor.instructorDetail = instructorDetail

            // Start a transaction
            session.beginTransaction()

            // Save the instructor object
            // NOTE: This will also save the details object because of CascadeType.ALL
            session.save(instructor)

            // Commit transaction
            session.transaction.commit()

            println("Done!")
        }
    }
}
