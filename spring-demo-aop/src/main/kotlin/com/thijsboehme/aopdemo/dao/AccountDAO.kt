package com.thijsboehme.aopdemo.dao

import org.springframework.stereotype.Component

@Component
class AccountDAO {
    fun addAccount() {
        println("$javaClass: DOING MY DB WORK: ADDING AN ACCOUNT")
    }
}
