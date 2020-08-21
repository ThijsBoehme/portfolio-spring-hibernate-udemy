package com.thijsboehme.aopdemo.dao

import com.thijsboehme.aopdemo.Account
import org.springframework.stereotype.Component

@Component
class AccountDAO {
    fun addAccount(account: Account, vip: Boolean) {
        println("$javaClass: DOING MY DB WORK: ADDING AN ACCOUNT")
    }

    fun doWork(): Boolean {
        println("$javaClass: doWork()")
        return true
    }
}
