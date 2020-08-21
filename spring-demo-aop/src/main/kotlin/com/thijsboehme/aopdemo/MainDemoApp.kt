package com.thijsboehme.aopdemo

import com.thijsboehme.aopdemo.dao.AccountDAO
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    // Read Spring config java class
    AnnotationConfigApplicationContext(DemoConfig::class.java).use { context ->
        // Get bean from Spring container
        val accountDAO = context.getBean("accountDAO", AccountDAO::class.java)

        // Call business method
        accountDAO.addAccount()

        // Do it again!
        println("Let's call it again!")
        accountDAO.addAccount()

        // Close the context
    }
}
