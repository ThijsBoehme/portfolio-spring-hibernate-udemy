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
        var accounts: List<Account>? = null

        try {
            // Add a boolean flag to simulate exceptions
            val tripWire = true
            accounts = accountDAO.findAccounts(tripWire)
        } catch (exception: Exception) {
            println()
            println("Main Program ... caught exception: $exception")
        }

        // Display the accounts
        println("\nMain Program: AfterFinallyDemoApp")
        println("----")
        println(accounts)
        println()

        // Close the context
    }
}
