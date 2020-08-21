package com.thijsboehme.aopdemo.dao

import org.springframework.stereotype.Component

@Component
class MembershipDAO {
    fun addAccount() {
        println("$javaClass: DOING STUFF: ADDING A MEMBERSHIP ACCOUNT")
    }

    fun addSillyMember(): Boolean {
        println("$javaClass: DOING STUFF: ADDING A MEMBERSHIP ACCOUNT")
        return true
    }
}
