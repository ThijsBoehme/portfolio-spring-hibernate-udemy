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

        // Get the instructor detail object
        val id = 4
        val instructorDetail: InstructorDetail? = session.get(InstructorDetail::class.java, id)

        // Break bidirectional link
        instructorDetail?.instructor?.instructorDetail = null

        // Delete the instructor detail
        session.delete(instructorDetail)

        // Commit transaction
        session.transaction.commit()

        println("Done!")
    }
}
