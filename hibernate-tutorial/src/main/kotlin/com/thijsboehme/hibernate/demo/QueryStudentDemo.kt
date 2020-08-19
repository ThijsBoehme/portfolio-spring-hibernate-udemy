package com.thijsboehme.hibernate.demo

import com.thijsboehme.hibernate.demo.entity.Student
import org.hibernate.cfg.Configuration

fun main() {
    // Create session factory
    val factory = Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student::class.java)
        .buildSessionFactory()

    factory.use {
        // Create session
        val session = it.currentSession

        // Start a transaction
        println("Starting a transaction")
        session.beginTransaction()

        // Query students
        var students = session.createQuery("from Student").resultList as List<Student>

        // Display the students
        displayStudents(students)

        // Query students: lastName = 'Doe'
        students = session.createQuery("from Student s where s.lastName='Doe'").resultList as List<Student>
        displayStudents(students)

        // Query students: lastName = 'Doe' OR firstName='Daffy'
        students = session.createQuery("from Student s where " +
                "s.lastName='Doe' OR s.firstName='Daffy'")
            .resultList as List<Student>
        displayStudents(students)

        // Query students: email ends with luv2code.com
        students = session.createQuery("from Student s where " +
                "s.email LIKE '%luv2code.com'")
            .resultList as List<Student>
        displayStudents(students)

        // Commit transaction
        println("Commit the transaction")
        session.transaction.commit()

        println("Done!")
    }
}

private fun displayStudents(students: List<Student>) {
    println()
    for (student in students) {
        println(student)
    }
    println()
}
