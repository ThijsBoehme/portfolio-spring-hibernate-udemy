package com.thijsboehme.testdb

import java.sql.DriverManager
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "TestDbServlet")
class TestDbServlet: HttpServlet() {
    override fun doGet(request: HttpServletRequest?, response: HttpServletResponse?) {
        // Setup connection variables
        val user = "springstudent"
        val password = "springstudent"

        val jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC"
        val driver = "com.mysql.jdbc.Driver"

        val writer = response?.writer
        writer?.println("Connecting to database: $jdbcURL")

        Class.forName(driver)

        DriverManager.getConnection(jdbcURL, user, password).use {
            writer?.println("Connection successful!")
        }
    }
}
