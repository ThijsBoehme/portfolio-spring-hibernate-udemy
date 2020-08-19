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

        // Start a transaction
        session.beginTransaction()

        // Get instructor by primary key / id
        val id = 1
        val instructor: Instructor? = session.get(Instructor::class.java, id)
        println("Found instructor: $instructor")

        // Delete the instructor
        // Note: this will also delete associated "details" because of CascadeType.ALL
        if (instructor != null) {
            println("Deleting: $instructor")
            session.delete(instructor)
        }

        // Commit transaction
        session.transaction.commit()

        println("Done!")
    }
}
