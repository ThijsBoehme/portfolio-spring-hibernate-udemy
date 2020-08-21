package com.thijsboehme.aopdemo

import com.thijsboehme.aopdemo.dao.AccountDAO
import com.thijsboehme.aopdemo.dao.MembershipDAO
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    // Read Spring config java class
    AnnotationConfigApplicationContext(DemoConfig::class.java).use { context ->
        // Get beans from Spring container
        val accountDAO = context.getBean("accountDAO", AccountDAO::class.java)

        // Call method to find the accounts
        val accounts = accountDAO.findAccounts()

        // Display the accounts
        println("\nMain Program: AfterReturningDemoApp")
        println("----")
        println(accounts)
        println()

        // Close the context
    }
}
