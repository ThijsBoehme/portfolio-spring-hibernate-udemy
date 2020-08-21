package com.thijsboehme.aopdemo.dao

import org.springframework.stereotype.Component

@Component
class MembershipDAO {
    fun addSillyMember(): Boolean {
        println("$javaClass: DOING STUFF: ADDING A MEMBERSHIP ACCOUNT")
        return true
    }

    fun goToSleep() {
        println("$javaClass: I'm going to sleep now...")
    }
}
