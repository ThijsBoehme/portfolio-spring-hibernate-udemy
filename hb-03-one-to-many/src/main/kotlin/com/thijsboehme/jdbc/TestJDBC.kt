package com.thijsboehme.jdbc

import java.sql.DriverManager
import java.sql.SQLException

class TestJDBC

fun main() {
    val jdbcURL = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC"
    val user = "hbstudent"
    val password = "hbstudent"

    try {
        println("Connecting to database: $jdbcURL")
        val connection = DriverManager.getConnection(jdbcURL, user, password)
        println("Connection successful!")
    } catch (error: SQLException) {
        println(error)
    }
}
