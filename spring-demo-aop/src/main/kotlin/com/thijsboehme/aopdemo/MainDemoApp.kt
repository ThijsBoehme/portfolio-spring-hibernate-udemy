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
        accountDAO.addAccount()

        // Call the membership business method
        membershipDAO.addSillyMember()

        // Close the context
    }
}
