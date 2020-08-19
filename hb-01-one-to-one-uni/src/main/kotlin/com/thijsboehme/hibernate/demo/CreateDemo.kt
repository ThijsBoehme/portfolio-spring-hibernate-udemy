package com.thijsboehme.hibernate.demo

import com.thijsboehme.hibernate.demo.entity.Instructor
import com.thijsboehme.hibernate.demo.entity.InstructorDetail
import org.hibernate.cfg.Configuration

fun main() {
    // Create session factory
    val factory = Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor::class.java)
        .addAnnotatedClass(InstructorDetail::class.java)
        .buildSessionFactory()

    factory.use {
        // Create session
        val session = it.currentSession

        // Create the objects
        /*
        val instructor = Instructor("Chad", "Darby", "darby@luv2code.com")
        val instructorDetail = InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!")
        */
        val instructor = Instructor("Madhu", "Patel", "madhu@luv2code.com")
        val instructorDetail = InstructorDetail("http://www.youtube.com", "Guitar")

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
