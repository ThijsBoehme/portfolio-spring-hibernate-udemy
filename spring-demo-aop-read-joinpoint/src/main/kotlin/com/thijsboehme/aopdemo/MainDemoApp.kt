package com.thijsboehme.aopdemo

import com.thijsboehme.aopdemo.dao.AccountDAO
import com.thijsboehme.aopdemo.dao.MembershipDAO
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    // Read Spring config java class
    AnnotationConfigApplicationContext(DemoConfig::class.java).use { context ->
        // Get beans from Spring container
        val accountDAO = context.getBean("accountDAO", AccountDAO::class.java)
        val membershipDAO = context.getBean("membershipDAO", MembershipDAO::class.java)

        // Call business method
        accountDAO.addAccount(Account("John Smith", "john@luv2code.com"), true)
        accountDAO.doWork()

        // Call the account getter/setter methods
        accountDAO.name = "fooBar"
        accountDAO.serviceCode = "silver"

        val name = accountDAO.name
        val serviceCode = accountDAO.serviceCode

        // Call the membership business method
        membershipDAO.addSillyMember()
        membershipDAO.goToSleep()

        // Close the context
    }
}
